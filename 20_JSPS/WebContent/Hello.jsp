<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" %>
    
<%@ include file="insert.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Demo</title>
</head>
<body>
	<h1>This is the demo </h1>
	<%
	Date date = new Date();
	out.print(date);
	%>
	
	<%-- COMMENT TAG --%>
	
	<%-- Expression tag --%>
	<%= new Date() %>
	
	<%-- Declaration tag --%>
	<%! String message = "Welcome"; %>
	<br>
	<b><%= message %></b>
	<%   
		String name=request.getParameter("username");  
		out.print("Welcome "+ name);  
		response.sendRedirect("https://geeksforgeeks.org"); 
	%> 
	
	
	
</body>
</html>