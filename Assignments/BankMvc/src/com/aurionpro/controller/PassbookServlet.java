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

@WebServlet("/Passbook")
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

        String type = request.getParameter("type");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String sortBy = request.getParameter("sortBy");
        String sortOrder = request.getParameter("sortOrder");

        if (sortBy == null || sortBy.isEmpty()) {
            sortBy = "TransactionDate"; // Default sorting by date
        }
        if (sortOrder == null || sortOrder.isEmpty()) {
            sortOrder = "DESC"; // Default sorting in descending order
        }

        try (Connection connection = DbUtil.getConnection()) {
            DbUtil dbUtil = new DbUtil();
            List<Transaction> transactions = dbUtil.getFilteredTransactions(connection, userID, null, type, startDate, endDate, sortBy, sortOrder);
            
            request.setAttribute("transactions", transactions);
            request.setAttribute("type", type);
            request.setAttribute("startDate", startDate);
            request.setAttribute("endDate", endDate);
            request.setAttribute("sortBy", sortBy);
            request.setAttribute("sortOrder", sortOrder);

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
