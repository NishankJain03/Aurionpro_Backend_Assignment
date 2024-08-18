package com.aurionpro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Customer")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CustomerServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");

        if (action == null) {
            // Handle null action
            request.setAttribute("errorMessage", "No action specified.");
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            return;
        }

        switch (action) {
            case "passbook":
                request.getRequestDispatcher("Passbook.jsp").forward(request, response);
                break;
            case "newTransaction":
                request.getRequestDispatcher("NewTransaction.jsp").forward(request, response);
                break;
            case "editProfile":
                request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("errorMessage", "Unknown action: " + action);
                request.getRequestDispatcher("Error.jsp").forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
