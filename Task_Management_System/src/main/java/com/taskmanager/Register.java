package com.taskmanager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		String name = req.getParameter("username");
		String password = req.getParameter("password");

		try {
			Connection conn = Dbconn.getConnection();
			
			String checkQuery = "SELECT * FROM users WHERE username = ?";
			PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
			checkStmt.setString(1, name);
			ResultSet resultSet = checkStmt.executeQuery();
			
			if (resultSet.next()) {
				req.setAttribute("errorMessage", "User name is already taken, please try something different");
				req.getRequestDispatcher("register.jsp").forward(req, res);
			} else {
				String insertQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
				PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
				insertStmt.setString(1, name);
				insertStmt.setString(2, password);
				insertStmt.executeUpdate();
				
				conn.close();
				res.sendRedirect("confirmation.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
