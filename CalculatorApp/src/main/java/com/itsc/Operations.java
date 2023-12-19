package com.itsc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Operations
 */
@WebServlet("/operation")
public class Operations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Operations() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String operation = request.getParameter("operation");

	        if ("addition".equals(operation)) {
	            jakarta.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/addition");
	            dispatcher.forward(request, response);
	        } else if ("multiplication".equals(operation)) {
	            jakarta.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/multiplication");
	            dispatcher.forward(request, response);
	        }  else if ("subtraction".equals(operation)) {
	            jakarta.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/subtraction");
	            dispatcher.forward(request, response);
	        }  else if ("division".equals(operation)) {
	            jakarta.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/division");
	            dispatcher.forward(request, response);
	        } else {
	            response.getWriter().println("Invalid operation");
	}

}
	}
