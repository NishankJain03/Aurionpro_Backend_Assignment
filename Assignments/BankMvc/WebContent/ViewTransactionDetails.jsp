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
        background-color: #f0f2f5;
        margin: 0;
        padding: 10px;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 120vh;
        margin-top: 20px
    }
    .container {
        max-width: 1000px;
        width: 100%;
        padding: 20px;
        background: #ffffff;
        border-radius: 8px;
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        margin-top:70px;
    }
    h2 {
        color: #333;
        margin-bottom: 20px;
        font-size: 28px;
        text-align: center;
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
        background-color: #007bff;
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
        padding: 10px 20px;
        font-size: 16px;
        color: #ffffff;
        background-color: #007bff;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s, transform 0.2s;
    }
    a:hover {
        background-color: #0056b3;
        transform: scale(1.05);
    }
    a:active {
        background-color: #004494;
        transform: scale(0.98);
    }
</style>
</head>
<body>
    <div class="container">
    
        <h2>Transaction Details</h2>
       <!-- <form action="ViewTransactionAdminServlet" method="get">
                <label for="type">Filter by type:</label>
                <select name="type" id="type" onchange="this.form.submit()">
                    <option value="all" ${param.type == 'all' ? 'selected' : ''}>All</option>
                    <option value="Credit" ${param.type == 'Credit' ? 'selected' : ''}>Credit</option>
                    <option value="Debit" ${param.type == 'Debit' ? 'selected' : ''}>Debit</option>
                    <option value="Transfer" ${param.type == 'Transfer' ? 'selected' : ''}>Transfer</option>
                </select>
            </form> -->
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
