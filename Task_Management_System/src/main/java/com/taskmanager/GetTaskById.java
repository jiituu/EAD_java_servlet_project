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

public class GetTaskById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int taskId = Integer.parseInt(req.getParameter("id"));
		String opr = req.getParameter("opr");

		if (opr.equals("edit")) {
			Task task = getTasksById(taskId);
			req.setAttribute("task", task);
			req.getRequestDispatcher("editTask.jsp").forward(req, res);
		}
	}

	private Task getTasksById(int taskId) {
	    Task task = new Task();

	    try {
	        Connection conn = Dbconn.getConnection();
	        String query = "SELECT * FROM tasks WHERE id = ?;";
	        PreparedStatement pstmt = conn.prepareStatement(query);
	        pstmt.setInt(1, taskId);

	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            task.setId(rs.getInt("id"));
	            task.setTaskTitle(rs.getString("task_title"));
	            task.setDescription(rs.getString("description"));
	            task.setDueDate(rs.getString("due_date"));
	            task.setPriority(rs.getString("priority"));
	        }
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("=====catche  " + taskId);
	    }
	    return task;
	}

}
