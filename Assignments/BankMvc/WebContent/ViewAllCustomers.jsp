<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>View Customers</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f4f7fa; /* Light slate background */
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 120vh;
    }
    .container {
        background: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        text-align: center;
        width: 100%;
        max-width: 500px; /* Adjusted for consistency */
    }
    h2 {
        color: #333;
        margin-bottom: 20px;
        font-size: 24px;
    }
    button, a {
        padding: 12px 20px;
        font-size: 16px;
        color: #ffffff;
        background-color: #1abc9c; /* Sea Green */
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s, transform 0.2s;
    }
    button:hover, a:hover {
        background-color: #16a085; /* Darker Sea Green */
        transform: scale(1.05);
    }
    button:active, a:active {
        background-color: #149174; /* Even Darker Sea Green */
        transform: scale(0.98);
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
        background: #ffffff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    th, td {
        border: 1px solid #ddd;
        padding: 12px;
        text-align: left;
    }
    th {
        background-color: #1abc9c;
        color: white;
        font-size: 18px;
    }
    td {
        background-color: #f9f9f9;
        color: #333;
    }
    tr:nth-child(even) td {
        background-color: #f1f1f1;
    }
</style>

</head>
<body>
    <div class="container">
        <h2>Customer Details</h2>
        

        <table>
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Account Number</th>
                    <th>Balance</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td>${customer.getFirstName()}</td>
                        <td>${customer.getLastName()}</td>
                        <td>${customer.account.getAccountNumber()}</td>
                        <td>${customer.account.getBalance()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
		<a href="viewCustomer.jsp">Back to Customer Details</a>
        <a href="Admin.jsp">Back to Home</a>
    </div>
</body>
</html>
