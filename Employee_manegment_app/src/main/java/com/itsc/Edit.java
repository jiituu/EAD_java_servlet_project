package com.itsc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class Edit
 */

@WebServlet("/editurl")
public class Edit extends HttpServlet {
	private static final String query ="update employeelist set name=?, designation=?, salary=?where id = ?";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		//set content type
		pw.println("<link rel='stylesheet' href='css/bootstrap.min.css'>"); 

		response.setContentType("text/html");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String designation = request.getParameter("designation");
		int salary = Integer.parseInt(request.getParameter("salary"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
			}
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/employee";
			String username = "root";
			String password = "root"; 
			Class.forName(driver); 
			Connection conn = DriverManager.getConnection(url,
			username, password);
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, designation);
			ps.setFloat(3, salary);
			ps.setInt(4, id);
			int count = ps.executeUpdate();
			if(count == 1) {
				  pw.println("<div class='alert alert-success'>");

				  pw.println("<h2>employee is edited successfully.</h2>");
				  pw.println("</div>");

			
			}else {
				  pw.println("<div class='alert alert-danger'>");

				  pw.println("<h2>employee not edited</h2>");
				  pw.println("</div>");

			
				}
			
		}catch (SQLException se) {
			se.printStackTrace();
			pw.println("<h1>" + se.getMessage() + "</h1>");
			} catch (Exception e) {
			e.printStackTrace();
			pw.println("<h1>" + e.getMessage() + "</h1>");
			}
			pw.println("<div class='text-center mt-3'>");
			pw.println("<a href='landingpage.html' class='btn btn-secondary m-2'>Home</a>");
			pw.print("<br>");
			pw.println("<a href='employeelist' class='btn btn-secondary m-2'>employee List</a>");
			pw.println("</div>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
