package com.aurionpro.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String errorMessage = validateInput(firstName, lastName, email, password);

        if (errorMessage != null) {
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        try (Connection connection = DbUtil.getConnection()) {
            if (isEmailAlreadyUsed(connection, email)) {
                request.setAttribute("errorMessage", "Email address already in use.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
                dispatcher.forward(request, response);
                return;
            }

            int userID = insertUser(connection, firstName, lastName, email, password);
            if (userID > 0) {
                if (insertCustomer(connection, userID)) {
                    request.setAttribute("message", "Customer added successfully.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("successPage.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
                request.setAttribute("errorMessage", "Failed to retrieve UserID.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
                dispatcher.forward(request, response);
                return;
            }
            request.setAttribute("errorMessage", "Failed to add customer.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
            dispatcher.forward(request, response);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while adding the customer.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private String validateInput(String firstName, String lastName, String email, String password) {
        StringBuilder errors = new StringBuilder();

        if (!isValidName(firstName)) {
            errors.append("First name can only contain letters.<br>");
        }
        if (!isValidName(lastName)) {
            errors.append("Last name can only contain letters.<br>");
        }
        if (!isValidPassword(password)) {
            errors.append("Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, one digit, and one special character.<br>");
        }

        return errors.length() > 0 ? errors.toString() : null;
    }

    private boolean isValidName(String name) {
        return name != null && name.matches("[a-zA-Z]+");
    }

    private boolean isValidPassword(String password) {
        return password != null &&
               password.length() > 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[a-z].*") &&
               password.matches(".*\\d.*") &&
               password.matches(".*[^a-zA-Z0-9].*");
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
