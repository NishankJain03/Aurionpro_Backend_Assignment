package com.aurionpro.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.model.DbUtil;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
        super.init();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("loginType");
        
        if (username.isEmpty() && password.isEmpty() &&  role.isEmpty()) {
        	 request.setAttribute("errorMessage", "Missing username, password, or role.");
             request.getRequestDispatcher("Error.jsp").forward(request, response);
             return;
        }

        String sql = "SELECT * FROM users WHERE FirstName = ? AND Password = ? AND Role = ?";
        
        try (Connection connection = DbUtil.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, role);

            ResultSet rs = pstmt.executeQuery();
            if (!rs.next()) {
                request.setAttribute("errorMessage", "Invalid username, password, or role.");
                request.getRequestDispatcher("Error.jsp").forward(request, response);
                return;
            }
            int userID = rs.getInt("userID");
                
                // Create a session and store the userID
            HttpSession session = request.getSession();
            session.setAttribute("userID", userID);
            if ("Admin".equalsIgnoreCase(role)) {
            	request.setAttribute("username", username);
            	request.getRequestDispatcher("Admin.jsp").forward(request, response);	
            	return;
            }
            	
            if ("Customer".equalsIgnoreCase(role)) {
            	request.setAttribute("username", username);
            	request.getRequestDispatcher("Customer.jsp").forward(request, response);
            	return;
            }
            
            request.setAttribute("errorMessage", "Invalid role.");
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database query problem.", e);
        }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


}
