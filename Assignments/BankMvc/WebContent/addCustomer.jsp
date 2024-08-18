<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Customer</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f4f7fa; /* Light grey background */
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        max-width: 600px;
        width: 100%;
        padding: 20px;
        background: #ffffff; /* White background */
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
    h2 {
        color: #333;
    }
    form {
        display: flex;
        flex-direction: column;
        gap: 15px;
        align-items: center;
        padding: 10px;
    }
    label {
        font-size: 16px;
        color: #555;
        align-self: flex-start;
    }
    input {
        width: 100%;
        max-width: 400px;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 4px;
        font-size: 16px;
    }
    input:focus {
        border-color: #007bff; /* Blue focus */
        outline: none;
    }
    button , .btn{
        padding: 10px 20px;
        font-size: 16px;
        color: #fff;
        background-color: #1abc9c; /* Sea Green */
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s;
    }
    button:hover, .btn:hover {
        background-color: #16a085; /* Darker Sea Green */
    }
    .form-actions {
        display: flex;
        gap: 10px;
        justify-content: center;
    }
    .form-actions button {
        width: 150px;
    }
    .form-actions .btn {
        width: 150px;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Add New Customer</h2>
        <form action="AddCustomerServlet" method="post">
            <label for="firstName">Customer First Name:</label>
            <input type="text" id="firstName" name="firstName" required>

            <label for="lastName">Customer Last Name:</label>
            <input type="text" id="lastName" name="lastName" required>

            <label for="email">Email ID:</label>
            <input type="email" id="email" name="email" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <div class="form-actions">
                <button type="submit" name="action" value="submit">Add Customer</button>
                <a href="Admin.jsp?action=cancel" class="btn">Cancel</a>
            </div>
            
            
            <c:if test="${not empty error}">
                <div style="color: red; margin-top: 10px;">
                    ${error}
                </div>
            </c:if>
        </form>
    </div>
</body>
</html>
