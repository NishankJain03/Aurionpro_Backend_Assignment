package com.aurionpro.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.model.Customer;
import com.aurionpro.model.DbUtil; // Import the DbUtil class
import com.aurionpro.operation.CustomerOperation;
import com.aurionpro.operation.AccountOperation;

@WebServlet("/AddBankAccount")
public class AddBankAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddBankAccountServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        AccountOperation accountOperation = new AccountOperation();
        
        try (Connection connection = DbUtil.getConnection()) { 
            if ("searchCustomer".equals(action)) {
                String customerId = request.getParameter("customerId");
                CustomerOperation customerOperation = new CustomerOperation();
                Customer customer = customerOperation.fetchCustomerById(connection, customerId);
                if (customer == null) {
                    // No customer found, forward to error page
                    request.setAttribute("errorMessage", "There's no user with the provided customer ID.");
                    request.getRequestDispatcher("Error.jsp").forward(request, response);
                    return;
                }
                request.setAttribute("customer", customer);
                request.getRequestDispatcher("ViewCustomerDetails.jsp").forward(request, response);
                return;
            } else if ("generateAccountNumber".equals(action)) {
                String customerId = request.getParameter("customerId");
                String result = accountOperation.createAccountForCustomer(connection, customerId);
                request.setAttribute("result", result);
                request.getRequestDispatcher("AccountCreationResult.jsp").forward(request, response);
                return;
            }
            request.getRequestDispatcher("AddBankAccount.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database error occurred.", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    

    
}
