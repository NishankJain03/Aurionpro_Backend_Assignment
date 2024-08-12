package com.aurionpro.controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.model.DbUtil;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginController() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		request.setAttribute("username", username);
		
		DbUtil dbUtil = DbUtil.getDbUtil();
		
		dbUtil.connectToDo();
		
		if(dbUtil.validateCredentials(username,password)) {
			requestDispatcher = request.getRequestDispatcher("LoginSuccess.jsp");
		}else {
			requestDispatcher = request.getRequestDispatcher("LoginFailed.jsp");
		}
		
		requestDispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
