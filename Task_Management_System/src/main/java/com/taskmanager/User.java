package com.taskmanager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/user")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		jakarta.servlet.http.HttpSession session = req.getSession();
		session.setAttribute("userName", "");
		session.setAttribute("userId", -1);
		res.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String username = req.getParameter("username");
		String newUsername = req.getParameter("newUsername");
		String currentPassword = req.getParameter("currentPassword");
		String newPassword = req.getParameter("newPassword");

		if (newPassword == null) {
			try {
				Connection conn = Dbconn.getConnection();

				String checkQuery = "SELECT username FROM users WHERE username = ?";
				PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
				checkStmt.setString(1, newUsername);
				ResultSet checkResult = checkStmt.executeQuery();

				if (checkResult.next()) {
					req.setAttribute("successMessage", null);
					req.setAttribute("errorMessage", "Username already taken, please try something differnet!");
					req.getRequestDispatcher("User.jsp").forward(req, res);
					conn.close();
					return;
				}

				String updateQuery = "UPDATE users SET username = ? WHERE username = ?";
				PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
				updateStmt.setString(1, newUsername);
				updateStmt.setString(2, username);

				int rowsAffected = updateStmt.executeUpdate();
				conn.close();

				if (rowsAffected > 0) {
					jakarta.servlet.http.HttpSession session = req.getSession();
					session.setAttribute("userName", newUsername);
					req.setAttribute("errorMessage", null);
					req.setAttribute("successMessage", "Username changed successfully! Your new user name is " + newUsername);
					req.getRequestDispatcher("User.jsp").forward(req, res);
				} else {
					req.setAttribute("successMessage", null);
					req.setAttribute("errorMessage", "Unable to change your username, Please try something different!");
					req.getRequestDispatcher("User.jsp").forward(req, res);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				req.setAttribute("successMessage", null);
				req.setAttribute("errorMessage", "Unable to change your username, Please try something different!");
				req.getRequestDispatcher("User.jsp").forward(req, res);
			}
		} else {
			try {
				Connection conn = Dbconn.getConnection();
				String query = "UPDATE users SET password = ? WHERE username = ? AND password = ?";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, newPassword);
				pstmt.setString(2, username);
				pstmt.setString(3, currentPassword);

				int rowsAffected = pstmt.executeUpdate();
				conn.close();

				if (rowsAffected > 0) {
					req.setAttribute("errorMessage", null);
					req.setAttribute("successMessage", "Password changed successfully!");
					req.getRequestDispatcher("User.jsp").forward(req, res);
				} else {
					req.setAttribute("successMessage", null);
					req.setAttribute("errorMessage", "The passowrd you entered is wrong, try again please!");
					req.getRequestDispatcher("User.jsp").forward(req, res);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				req.setAttribute("successMessage", null);
				req.setAttribute("errorMessage", "Unable to change your password, please try again later!");
				req.getRequestDispatcher("User.jsp").forward(req, res);
			}
		}

	}
}