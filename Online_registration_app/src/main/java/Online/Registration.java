package Online;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		 try (Connection conn = Dbconn.getConnection()) {
		        String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
		        PreparedStatement pstmt = conn.prepareStatement(query);

		        pstmt.setString(1, name);
		        pstmt.setString(2, email);
		        pstmt.setString(3, password);
		        pstmt.executeUpdate();

		        response.sendRedirect("confirmation.jsp");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
			
	}
	
}

