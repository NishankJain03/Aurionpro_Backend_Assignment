package com.aurionpro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		RequestDispatcher dispatcher = null;
		switch (action) {
        case "addCustomer":
            dispatcher = request.getRequestDispatcher("addCustomer.jsp");
            break;
        case "addAccount":
            dispatcher = request.getRequestDispatcher("AddBankAccount.jsp");
            break;
        case "viewCustomer":
            dispatcher = request.getRequestDispatcher("viewCustomer.jsp");
            break;
        case "viewTransaction":
            dispatcher = request.getRequestDispatcher("viewTransaction.jsp");
            break;
        default:
            // Handle invalid action
            dispatcher = request.getRequestDispatcher("Error.jsp");
            break;
    }

    // Forward the request to the appropriate JSP
    if (dispatcher != null) {
        dispatcher.forward(request, response);
    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
