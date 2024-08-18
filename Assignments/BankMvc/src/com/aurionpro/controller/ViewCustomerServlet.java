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
import com.sun.corba.se.spi.orbutil.fsm.Action;

@WebServlet("/ViewCustomerDetails")
public class ViewCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ViewCustomerServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
        List<Customer> customers;
        try (Connection connection = DbUtil.getConnection()) {
        	if ("viewDetails".equals(action)) {
                customers = fetchAllCustomers(connection, null, null); // Fetch all customers
            } else if ("search".equals(action)) {
                String searchTerm = request.getParameter("searchTerm");
                customers = fetchAllCustomers(connection, "search", searchTerm); // Fetch customers based on search term
            } else {
                customers = fetchAllCustomers(connection, action, null); // Fetch sorted customers
            }
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

    private List<Customer> fetchAllCustomers(Connection connection, String action, String searchTerm) {
        List<Customer> customers = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT u.FirstName, u.LastName, a.AccountNumber, a.Balance " +
                       "FROM Customers c " +
                       "JOIN Users u ON c.UserID = u.UserID " +
                       "LEFT JOIN Accounts a ON c.CustomerID = a.CustomerID");
        
        if ("search".equals(action) && searchTerm != null && !searchTerm.trim().isEmpty()) {
            query.append(" WHERE u.FirstName LIKE ? OR u.LastName LIKE ? OR a.AccountNumber LIKE ? OR a.Balance LIKE ?");
        } else if (action != null) {
            switch(action) {
                case "firstName":
                    query.append(" ORDER BY u.FirstName");
                    break;
                case "lastName":
                    query.append(" ORDER BY u.LastName");
                    break;
                case "accountNumber":
                    query.append(" ORDER BY a.AccountNumber");
                    break;
                case "balance":
                    query.append(" ORDER BY a.Balance");
                    break;
                default:
                    System.out.println("Invalid Options");
            }
        }
        
        
        try (PreparedStatement stmt = connection.prepareStatement(query.toString())) {
            if ("search".equals(action) && searchTerm != null && !searchTerm.trim().isEmpty()) {
                String searchPattern = "%" + searchTerm + "%";
                stmt.setString(1, searchPattern);
                stmt.setString(2, searchPattern);
                stmt.setString(3, searchPattern);
                stmt.setString(4, searchPattern);
            }
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Customer customer = new Customer();
                    customer.setFirstName(rs.getString("FirstName"));
                    customer.setLastName(rs.getString("LastName"));

                    Account account = new Account(rs.getString("AccountNumber"));
                    account.setBalance(rs.getBigDecimal("Balance"));

                    customer.setAccount(account);
                    customers.add(customer);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // list of customer objects
        return customers;
    }
}
