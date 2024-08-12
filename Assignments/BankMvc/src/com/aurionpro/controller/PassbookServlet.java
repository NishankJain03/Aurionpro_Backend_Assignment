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
import javax.servlet.http.HttpSession;

import com.aurionpro.model.DbUtil;
import com.aurionpro.model.Transaction;

@WebServlet("/PassbookServlet")
public class PassbookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PassbookServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userID = (Integer) session.getAttribute("userID");

        if (userID == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        // Got a connection from DbUtil
        try (Connection connection = DbUtil.getConnection()) {
            // Used the connection to get transactions
            DbUtil dbUtil = new DbUtil();
            List<Transaction> transactions = dbUtil.getAllTransactions(connection, userID);
            
            request.setAttribute("transactions", transactions);
            request.getRequestDispatcher("PassbookView.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database error occurred.");
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
