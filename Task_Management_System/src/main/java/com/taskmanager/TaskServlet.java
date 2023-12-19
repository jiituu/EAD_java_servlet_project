package com.taskmanager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/task")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String taskId = request.getParameter("id");
		String username = request.getParameter("username");
		String opr = request.getParameter("opr");
		int userId = Integer.parseInt(request.getParameter("userId"));

		if (opr.equals("edit")) {
			response.sendRedirect("getTaskById?id=" + taskId + "&opr=" + opr);
		} else {
			try {
				Connection conn = Dbconn.getConnection();
				String query = "DELETE FROM tasks WHERE id=?";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, taskId);

				pstmt.executeUpdate();

				response.sendRedirect("dashboard?userId=" + userId);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Add a new task
		String taskTitle = request.getParameter("taskTitle");
		String description = request.getParameter("description");
		String dueDate = request.getParameter("dueDate");
		String priority = request.getParameter("priority");
		String username = request.getParameter("username");
		int userId = Integer.parseInt(request.getParameter("userId"));

		System.out.println("======userid===========  " + userId);

		try {
			Connection conn = Dbconn.getConnection();
			String query = "INSERT INTO tasks (task_title, description, due_date, priority, userId) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, taskTitle);
			pstmt.setString(2, description);
			pstmt.setString(3, dueDate);
			pstmt.setString(4, priority);
			pstmt.setInt(5, userId);

			pstmt.executeUpdate();

			response.sendRedirect("dashboard?userId=" + userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Update an existing task
		String taskId = request.getParameter("taskId");
		String taskTitle = request.getParameter("taskTitle");
		String description = request.getParameter("description");
		String dueDate = request.getParameter("dueDate");
		String priority = request.getParameter("priority");
		String username = request.getParameter("username");

		try {
			Connection conn = Dbconn.getConnection();
			String query = "UPDATE tasks SET task_title=?, description=?, due_date=?, priority=?, username=? WHERE id=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, taskTitle);
			pstmt.setString(2, description);
			pstmt.setString(3, dueDate);
			pstmt.setString(4, priority);
			pstmt.setString(5, taskId);
			pstmt.setString(6, username);

			pstmt.executeUpdate();

			conn.close();
			response.sendRedirect("tasks");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String taskId = request.getParameter("id");
		String username = request.getParameter("username");

		try {
			Connection conn = Dbconn.getConnection();
			String query = "DELETE FROM tasks WHERE id=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, taskId);

			pstmt.executeUpdate();

			response.sendRedirect("dashboard?username=" + username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
