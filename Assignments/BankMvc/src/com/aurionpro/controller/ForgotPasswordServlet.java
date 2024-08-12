package com.aurionpro.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.aurionpro.model.DbUtil;
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ForgotPasswordServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        String newPassword = request.getParameter("newPassword");
        String reTypePassword = request.getParameter("reTypePassword");
        
        if (accountNumber.isEmpty() && newPassword.isEmpty() && reTypePassword.isEmpty()) {
        	response.getWriter().write("Missing required fields.");
            return;
        }
        if (!newPassword.equals(reTypePassword)) {
        	response.getWriter().write("Passwords do not match.");
            return;
        }
        

        try (Connection conn = DbUtil.getConnection()) {
            if (updatePassword(conn, accountNumber, newPassword,response)) {
            	response.getWriter().write("Password updated successfully.");
            	return;
            } 
            response.getWriter().write("Error updating password or account number not found.");
            return;
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Database error: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    private boolean updatePassword(Connection conn, String accountNumber, String newPassword,HttpServletResponse response) throws SQLException {
        String query = "SELECT u.UserID, u.Password FROM Accounts a "
                     + "JOIN Customers c ON a.CustomerID = c.CustomerID "
                     + "JOIN Users u ON c.UserID = u.UserID "
                     + "WHERE a.AccountNumber = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, accountNumber);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int userID = rs.getInt("UserID");
                    String currentPassword = rs.getString("Password");

                    if (newPassword.equals(currentPassword)) {
                    	try {
							response.getWriter().write("New password cannot be the same as the current password.");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        return false;
                    }

                    String updateQuery = "UPDATE Users SET Password = ? WHERE UserID = ?";
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                        updateStmt.setString(1, newPassword); 
                        updateStmt.setInt(2, userID);
                        //is database operation successful
                        return updateStmt.executeUpdate() > 0;
                    }
                }
                return false;
            }
        }
}
   }