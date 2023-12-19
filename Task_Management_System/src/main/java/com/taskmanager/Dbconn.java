package com.taskmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconn {
	private static final String URL = "jdbc:mysql://localhost:3306/taskmanager";
	private static final String PASSWORD = "root";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USER = "root";

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
