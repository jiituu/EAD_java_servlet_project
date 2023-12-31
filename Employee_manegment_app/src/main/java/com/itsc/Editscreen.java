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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class Editscreen
 */

@WebServlet("/editScreen")
public class Editscreen extends HttpServlet {
	private static final String query ="select name, designation, salary from employeelist where id = ?";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editscreen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<link rel='stylesheet' href='css/bootstrap.min.css'>"); 

        response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("id"));
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
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        
	        rs.next();
	     // Link Bootstrap CSS 

	        pw.println("<div class='container mt-5'>");

	        pw.println("<h2>Edit Employee</h2>");

	        pw.println("<form action = 'editurl?id="+id+"' method = 'post'>");

	        pw.println("<div class='form-group'>");
	        pw.println("<label>Name</label>");
	        pw.println("<input type='text' class='form-control' name='name' value='"+rs.getString(1)+"'>");  
	        pw.println("</div>");

	        pw.println("<div class='form-group'>");
	        pw.println("<label>Designation</label>");
	        pw.println("<input type='text' class='form-control' name='designation' value='"+rs.getString(2)+"'>");
	        pw.println("</div>");

	        pw.println("<div class='form-group'>");
	        pw.println("<label>Salary</label>");
	        pw.println("<input type='text' class='form-control' name='salary' value='"+rs.getInt(3)+"'>");
	        pw.println("</div>");

	        pw.println("<button type='submit' class='btn btn-primary'>Save</button>");
	        pw.println("<a href='employeelist' class='btn btn-secondary'>Cancel</a>");

	        pw.println("</form>");
	        pw.println("</div>");
        	
        } catch (SQLException se) {
            se.printStackTrace();
            pw.println("<h1>" + se.getMessage() + "</h1>");
        } catch (Exception e) {
            e.printStackTrace();
            pw.println("<h1>" + e.getMessage() + "</h1>");
        }
            pw.println("<a href='landingpage.html' class='btn btn-secondary m-2' '>Home</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
