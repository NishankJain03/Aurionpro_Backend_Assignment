<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>New Transaction</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f4f7fa; /* Lighter off-white background */
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        background: #ffffff;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 90%;
        max-width: 600px;
    }
    h2 {
        color: #333;
        margin-bottom: 20px;
        font-size: 28px;
        text-align: center;
    }
    label {
        font-size: 16px;
        color: #555;
        margin-bottom: 5px;
        display: block;
    }
    input[type="text"],
    input[type="number"],
    select {
        width: calc(100% - 20px);
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 16px;
    }
    button {
        background-color: #1abc9c; /* Sea Green */
        color: #ffffff;
        border: none;
        padding: 10px 20px;
        font-size: 16px;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s, transform 0.2s;
    }
    button:hover {
        background-color: #16a085; /* Darker Sea Green */
        transform: scale(1.05);
    }
    button:active {
        background-color: #149174; /* Even darker Sea Green */
        transform: scale(0.98);
    }
    .cancel-button {
        background-color: #dc3545;
        margin-left: 10px;
    }
    .cancel-button:hover {
        background-color: #c82333;
    }
    .cancel-button:active {
        background-color: #bd2130;
    }
</style>
<script type="text/javascript">
    function toggleAccountNumber() {
        var transactionType = document.getElementById('transactionType').value;
        var accountNumberField = document.getElementById('accountNumber');
        if (transactionType === 'Transfer') {
            accountNumberField.disabled = false;
        } else {
            accountNumberField.disabled = true;
            accountNumberField.value = ''; // Clear the account number if not needed
        }
    }
</script>
</head>
<body>
    <div class="container">
        <h2>New Transaction</h2>
        <form action="NewTransaction" method="post">
            <label for="transactionType">Transaction Type:</label>
            <select id="transactionType" name="transactionType" onchange="toggleAccountNumber()" required>
                <option value="Debit">Debit</option>
                <option value="Credit">Credit</option>
                <option value="Transfer">Transfer</option>
            </select>

            <label for="accountNumber">Account Number:</label>
            <input type="text" id="accountNumber" name="accountNumber" disabled />

            <label for="amount">Amount:</label>
            <input type="number" id="amount" name="amount" step="0.01" min="0" required />

            <div style="text-align: center;">
                <button type="submit">Submit</button>
                <button type="button" class="cancel-button" onclick="window.location.href='CustomerServlet?action=passbook'">Cancel</button>
            </div>
        </form>
    </div>
</body>
</html>
