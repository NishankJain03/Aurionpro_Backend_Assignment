<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Search Customer</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #ecf0f1; /* Off White */
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        max-width: 500px;
        width: 100%;
        padding: 20px;
        background: #ffffff;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
    h1 {
        color: #333;
        margin-bottom: 20px;
    }
    form {
        display: flex;
        flex-direction: column;
        gap: 15px;
        align-items: center;
    }
    input[type="text"] {
        width: 100%;
        max-width: 400px;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 4px;
        font-size: 16px;
        box-sizing: border-box;
    }
    input[type="text"]:focus {
        border-color: #007bff;
        outline: none;
    }
    button {
        padding: 10px 20px;
        font-size: 16px;
        color: #fff;
        background-color: #1abc9c; /* Sea Green */
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s;
    }
    button:hover {
        background-color: #16a085; /* Darker Sea Green */
    }
    p {
        font-size: 18px;
        color: #555;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Search Customer</h1>
        <form action="AddBankAccountServlet" method="get">
            <input type="hidden" name="action" value="searchCustomer">
            <p>Search Customer by ID:</p>
            <input type="text" name="customerId" required placeholder="Enter Customer ID">
            <button type="submit">Search</button>
        </form>
    </div>
</body>
</html>
