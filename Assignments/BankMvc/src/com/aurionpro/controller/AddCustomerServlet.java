package com.aurionpro.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.model.DbUtil;

@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AddCustomerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

        if ("cancel".equals(action)) {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("Admin.jsp");
            dispatcher.forward(request, response);
            return;
        }

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (areFieldsEmpty(firstName, lastName, email, password)) {
            request.setAttribute("error", "All fields are required.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addCustomer.jsp");
            dispatcher.forward(request, response);
            return;
        }

        try (Connection connection = DbUtil.getConnection()) {
            if(isEmailAlreadyUsed(connection, email)) {
            	request.setAttribute("error", "Email address already in use.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("addCustomer.jsp");
                dispatcher.forward(request, response);
                return;
            }

            // Insert into Users table
            int userID = insertUser(connection, firstName, lastName, email, password);
            if (userID > 0) {
            	//insert into the customer table
                if (insertCustomer(connection, userID)) {
                    request.setAttribute("message", "Customer added successfully.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("successPage.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
                request.setAttribute("error", "Failed to retrieve UserID.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("addCustomer.jsp");
                dispatcher.forward(request, response);
                return;
            } 
            request.setAttribute("error", "Failed to add customer.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addCustomer.jsp");
            dispatcher.forward(request, response);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "An error occurred while adding the customer.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addCustomer.jsp");
            dispatcher.forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private boolean areFieldsEmpty(String firstName, String lastName, String email, String password) {
		return firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty();
	}
	private boolean isEmailAlreadyUsed(Connection connection, String email) throws SQLException {
        String checkEmailSQL = "SELECT COUNT(*) FROM Users WHERE Email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(checkEmailSQL)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }
	 private int insertUser(Connection connection, String firstName, String lastName, String email, String password) throws SQLException {
	        String insertUserSQL = "INSERT INTO Users (FirstName, LastName, Email, Password, Role) VALUES (?, ?, ?, ?, 'Customer')";
	        try (PreparedStatement stmt = connection.prepareStatement(insertUserSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
	            stmt.setString(1, firstName);
	            stmt.setString(2, lastName);
	            stmt.setString(3, email);
	            stmt.setString(4, password);
	            int rowsInserted = stmt.executeUpdate();
	            if (rowsInserted > 0) {
	                try (ResultSet rs = stmt.getGeneratedKeys()) {
	                    if (rs.next()) {
	                        return rs.getInt(1);
	                    }
	                }
	            }
	        }
	        return -1;
	    }
	  private boolean insertCustomer(Connection connection, int userID) throws SQLException {
	        String insertCustomerSQL = "INSERT INTO Customers (UserID) VALUES (?)";
	        try (PreparedStatement stmt = connection.prepareStatement(insertCustomerSQL)) {
	            stmt.setInt(1, userID);
	            return stmt.executeUpdate() > 0;
	        }
	    }

}
