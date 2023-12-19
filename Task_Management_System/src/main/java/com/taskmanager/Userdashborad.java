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
import java.util.ArrayList;
import java.util.List;

public class Userdashborad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int userId = Integer.parseInt(req.getParameter("userId"));
		String searchText = req.getParameter("searchText");

		if (searchText == null) {
			List<Task> tasks = getTasksForUser(userId);

			req.setAttribute("tasks", tasks);
			req.getRequestDispatcher("dashboard.jsp").forward(req, res);
		} else {
			List<Task> tasks = searchTasksByTitle(userId, searchText);
			req.setAttribute("tasks", tasks);
			req.getRequestDispatcher("dashboard.jsp").forward(req, res);
		}

	}

	private List<Task> getTasksForUser(int userId) {
		List<Task> tasks = new ArrayList<>();

		try {
			Connection conn = Dbconn.getConnection();
			String query = "SELECT * FROM tasks WHERE userId = ? ORDER BY FIELD(priority, 'High', 'Medium', 'Low')";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setTaskTitle(rs.getString("task_title"));
				task.setDescription(rs.getString("description"));
				task.setDueDate(rs.getString("due_date"));
				task.setPriority(rs.getString("priority"));

				tasks.add(task);
			}

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tasks;
	}

	private List<Task> searchTasksByTitle(int userId, String searchText) {
		List<Task> tasks = new ArrayList<>();

		try {
			Connection conn = Dbconn.getConnection();
			String query = "SELECT * FROM tasks WHERE userId = ? AND task_title LIKE ? ORDER BY FIELD(priority, 'High', 'Medium', 'Low')";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userId);
			pstmt.setString(2, "%" + searchText + "%");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setTaskTitle(rs.getString("task_title"));
				task.setDescription(rs.getString("description"));
				task.setDueDate(rs.getString("due_date"));
				task.setPriority(rs.getString("priority"));

				tasks.add(task);
			}

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tasks;
	}

}

//last part