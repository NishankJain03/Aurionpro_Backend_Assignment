package com.aurionpro.controller;

import java.io.IOException;
import java.math.BigDecimal;
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
import com.aurionpro.model.TransactionOperation;

@WebServlet("/NewTransaction")
public class NewTransactionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public NewTransactionServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String transactionType = request.getParameter("transactionType");
        String accountNumber = request.getParameter("accountNumber");
        BigDecimal amount = new BigDecimal(request.getParameter("amount"));
        HttpSession session = request.getSession();
        Integer userID = (Integer) session.getAttribute("userID");

        if (userID == null) {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
            return;
        }

        try (Connection connection = DbUtil.getConnection()) {
            connection.setAutoCommit(false);
            TransactionOperation transactionOperation = new TransactionOperation(connection);

            int senderAccountID = transactionOperation.getSenderAccountID(userID);

            if (senderAccountID == -1) {
                throw new ServletException("Sender account not found.");
            }
            
            switch (transactionType) {
            case "Transfer":
            	int receiverAccountID = transactionOperation.getAccountIDByNumber(accountNumber);
            	if(senderAccountID == receiverAccountID) {
            		throw new ServletException("Account ID are same");
            	}
            	if (receiverAccountID == -1) {
                    throw new ServletException("Receiver account not found.");
                }

                if (!transactionOperation.hasSufficientBalance(senderAccountID, amount)) {
                    throw new ServletException("Insufficient balance.");
                }
                transactionOperation.processTransfer(senderAccountID, receiverAccountID, amount);
                break;
            case "Debit":
                if (!transactionOperation.hasSufficientBalance(senderAccountID, amount)) {
                    throw new ServletException("Insufficient balance.");
                }

                transactionOperation.processDebit(senderAccountID, amount);
                break;
            case "Credit":
            	transactionOperation.processCredit(senderAccountID, amount);
                break;
            default:
                throw new ServletException("Invalid transaction type.");
        }
            connection.commit();
            RequestDispatcher dispatcher = request.getRequestDispatcher("TransactionSuccess.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException e) {
        	request.setAttribute("error", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("TransactionFailure.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
