<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>View Transaction Details</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f4f7fa; /* Light slate background */
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 180vh;
    }
    .container {
        background: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        text-align: center;
        width: 100%;
        max-width: 1000px; /* Adjusted for consistency */
    }
    h2 {
        color: #333;
        margin-bottom: 20px;
        font-size: 28px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    table, th, td {
        border: 1px solid #ddd;
    }
    th, td {
        padding: 12px;
        text-align: left;
    }
    th {
        background-color: #1abc9c; /* Sea Green */
        color: #ffffff;
        font-size: 18px;
    }
    td {
        background-color: #ffffff;
        color: #333;
    }
    tr:nth-child(even) td {
        background-color: #f9f9f9;
    }
    a {
        display: inline-block;
        margin-top: 20px;
        padding: 12px 20px;
        font-size: 16px;
        color: #ffffff;
        background-color: #1abc9c; /* Sea Green */
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s, transform 0.2s;
    }
    a:hover {
        background-color: #16a085; /* Darker Sea Green */
        transform: scale(1.05);
    }
    a:active {
        background-color: #149174; /* Even Darker Sea Green */
        transform: scale(0.98);
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Transaction Details</h2>
        <!-- Uncomment the form if you need filters -->
        <!--
        <form action="ViewTransactionAdminServlet" method="get">
            <label for="type">Filter by type:</label>
            <select name="type" id="type" onchange="this.form.submit()">
                <option value="all" ${param.type == 'all' ? 'selected' : ''}>All</option>
                <option value="Credit" ${param.type == 'Credit' ? 'selected' : ''}>Credit</option>
                <option value="Debit" ${param.type == 'Debit' ? 'selected' : ''}>Debit</option>
                <option value="Transfer" ${param.type == 'Transfer' ? 'selected' : ''}>Transfer</option>
            </select>
        </form>
        -->
        <table>
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
                        <td><c:out value="${transaction.getSenderAccountNumber()}"/></td>
                        <td><c:out value="${transaction.getReceiverAccountNumber()}"/></td>
                        <td><c:out value="${transaction.getTransactionType()}"/></td>
                        <td><c:out value="${transaction.getAmount()}"/></td>
                        <td><c:out value="${transaction.getTransactionDate()}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="Admin.jsp">Back to Home</a>
    </div>
</body>
</html>
