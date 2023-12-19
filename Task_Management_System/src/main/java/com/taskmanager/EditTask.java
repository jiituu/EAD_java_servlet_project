package com.taskmanager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String taskId = request.getParameter("taskId");
		String taskTitle = request.getParameter("taskTitle");
		String description = request.getParameter("description");
		String dueDate = request.getParameter("dueDate");
		String priority = request.getParameter("priority");
		int userId = Integer.parseInt(request.getParameter("userId"));

		
		try {
			Connection conn = Dbconn.getConnection();
			String query = "UPDATE tasks SET task_title=?, description=?, due_date=?, priority=?, userId=? WHERE id=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, taskTitle);
			pstmt.setString(2, description);
			pstmt.setString(3, dueDate);
			pstmt.setString(4, priority);
			pstmt.setInt(5, userId);
			pstmt.setString(6, taskId);

			pstmt.executeUpdate();

			conn.close();
			response.sendRedirect("dashboard?userId=" + userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
