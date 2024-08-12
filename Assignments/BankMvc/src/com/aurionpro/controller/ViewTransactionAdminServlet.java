package com.aurionpro.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.model.DbUtil;
import com.aurionpro.model.Transaction;

@WebServlet("/ViewTransactionAdminServlet")
public class ViewTransactionAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ViewTransactionAdminServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	String type = request.getParameter("type");
//    	System.out.println(type);
//    	if (type == null || type.isEmpty()) {
//            type = "all"; // Default value
//        }
    	List<Transaction> transactions;
        try (Connection connection = DbUtil.getConnection()) { 
            DbUtil dbUtil = new DbUtil(); // Created instance of DbUtil
            transactions = dbUtil.getAllAdminTransactions(connection);
//          transactions = dbUtil.getFilteredTransactions(connection, type);
            request.setAttribute("transactions", transactions);
            request.getRequestDispatcher("ViewTransactionDetails.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database error occurred.", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
