package com.aurionpro.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.model.Account;
import com.aurionpro.model.Customer;
import com.aurionpro.model.DbUtil; // Import DbUtil

@WebServlet("/ViewCustomerServlet")
public class ViewCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ViewCustomerServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers;
        try (Connection connection = DbUtil.getConnection()) {
            customers = fetchAllCustomers(connection);
            request.setAttribute("customers", customers);
            request.getRequestDispatcher("ViewAllCustomers.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database error occurred.", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private List<Customer> fetchAllCustomers(Connection connection) {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT u.FirstName, u.LastName, a.AccountNumber, a.Balance " +
                       "FROM Customers c " +
                       "JOIN Users u ON c.UserID = u.UserID " +
                       "LEFT JOIN Accounts a ON c.CustomerID = a.CustomerID";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setFirstName(rs.getString("FirstName"));
                customer.setLastName(rs.getString("LastName"));
                
                // Creating an Account object and setting account details
                Account account = new Account(rs.getString("AccountNumber"));
                account.setBalance(rs.getBigDecimal("Balance"));

                customer.setAccount(account);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // list of customer objects
        return customers;
    }
}
