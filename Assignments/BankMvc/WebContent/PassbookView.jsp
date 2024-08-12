<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Transaction Details</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f4f7fa; /* Light slate background */
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        background: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 800px;
    }
    h2 {
        color: #333;
        margin-bottom: 20px;
        font-size: 24px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    th, td {
        padding: 12px;
        border: 1px solid #ddd;
        text-align: left;
    }
    th {
        background-color: #1abc9c; /* Sea Green */
        color: black;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    .button {
        padding: 12px 20px;
        font-size: 16px;
        color: #ffffff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s, transform 0.2s;
        text-decoration: none; /* Remove underline */
        display: inline-block; /* Make sure it behaves like a button */
    }
    .button.primary {
        background-color: #1abc9c; /* Sea Green */
    }
    .button.primary:hover {
        background-color: #16a085; /* Darker Sea Green */
        transform: scale(1.05);
    }
    .button.primary:active {
        background-color: #149174; /* Even Darker Sea Green */
        transform: scale(0.98);
    }
    .button.cancel {
        background-color: #6c757d; /* Grey color for cancel button */
    }
    .button.cancel:hover {
        background-color: #5a6268;
    }
    .button.cancel:active {
        background-color: #4e555b;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Transaction Details</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Sender Account Number</th>
                    <th>Receiver Account Number</th>
                    <th>Transaction Type</th>
                    <th>Amount</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="transaction" items="${transactions}">
                    <tr>
                        <td><c:out value="${transaction.senderAccountNumber}" /></td>
                        <td><c:out value="${transaction.receiverAccountNumber}" /></td>
                        <td><c:out value="${transaction.transactionType}" /></td>
                        <td><c:out value="${transaction.amount}" /></td>
                        <td><c:out value="${transaction.transactionDate}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="Customer.jsp" class="button cancel">Cancel</a>
    </div>
</body>
</html>
