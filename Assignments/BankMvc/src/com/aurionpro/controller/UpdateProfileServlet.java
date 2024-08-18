package com.aurionpro.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import com.aurionpro.model.DbUtil;
import com.aurionpro.model.UserOperation;

@WebServlet("/UpdateProfile")
public class UpdateProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateProfileServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName").trim();
        String lastName = request.getParameter("lastName").trim();
        String password = request.getParameter("password").trim();

        // Validate inputs
        StringBuilder errorMessages = new StringBuilder();

        if (firstName == null || firstName.length() < 2) {
            errorMessages.append("First name must be at least 2 characters long.<br>");
        }
        if (lastName == null || lastName.length() < 2) {
            errorMessages.append("Last name must be at least 2 characters long.<br>");
        }
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        if (password == null || !password.matches(passwordPattern)) {
            errorMessages.append("Password must be at least 8 characters long, include one uppercase letter, one lowercase letter, one digit, and one special character.<br>");
        }

        if (errorMessages.length() > 0) {
            request.setAttribute("errorMessage", errorMessages.toString());
            RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateProfile.jsp");
            dispatcher.forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        Integer userID = (Integer) session.getAttribute("userID");

        if (userID == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
            return;
        }

        try (Connection connection = DbUtil.getConnection()) {
            UserOperation userOperation = new UserOperation(connection);

            boolean success = userOperation.updateUserProfile(userID, firstName, lastName, password);

            if (success) {
                if (password != null && !password.isEmpty()) {
                    session.invalidate();
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp?message=passwordUpdated");
                    dispatcher.forward(request, response);
                    return;
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("Customer.jsp");
                dispatcher.forward(request, response);
                return;    
            }
            request.setAttribute("errorMessage", "Update failed. Please try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateProfile.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database update problem.", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
