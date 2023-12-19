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

public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            Connection conn = Dbconn.getConnection();
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
          
                String userName = rs.getString("username");
                int userId = rs.getInt("id");

                jakarta.servlet.http.HttpSession session = req.getSession();
                session.setAttribute("userName", userName);
                session.setAttribute("userId", userId);
           
                res.sendRedirect("dashboard?userId=" + userId);
            } else {
                
                conn.close();
                req.setAttribute("errorMessage", "Invalid credential, Please try again");
				req.getRequestDispatcher("login.jsp").forward(req, res);
         
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}