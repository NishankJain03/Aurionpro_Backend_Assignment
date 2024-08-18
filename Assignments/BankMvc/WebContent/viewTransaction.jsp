<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>View Transaction</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f4f7fa; /* Light slate background */
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh; /* Ensure minimum height is 100% of viewport */
        box-sizing: border-box; /* Include padding and border in element's total width and height */
    }
    .container {
        background: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        width: 100%;
        max-width: 600px; /* Adjusted for a more professional width */
        overflow: auto; /* Enable scrolling if content overflows */
    }
    h2 {
        color: #2c3e50;
        margin-bottom: 20px;
        font-size: 28px; /* Slightly larger for emphasis */
        font-weight: 600;
    }
    form {
        display: flex;
        flex-direction: column;
    }
    .form-group {
        margin-bottom: 15px;
    }
    .form-group label {
        display: block;
        font-weight: 500;
        color: #34495e;
        margin-bottom: 5px;
    }
    .form-group input[type="text"],
    .form-group select,
    .form-group input[type="date"] {
        width: 100%;
        padding: 12px;
        font-size: 16px;
        border: 1px solid #dfe6e9;
        border-radius: 5px;
        box-sizing: border-box;
    }
    .form-group input[type="date"] {
        padding: 11px; /* Adjust padding for date inputs */
    }
    button, a {
        padding: 12px 24px;
        font-size: 16px;
        color: #ffffff;
        background-color: #1abc9c; /* Sea Green */
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s, transform 0.2s;
        text-decoration: none; /* For links */
        display: inline-block; /* To ensure button styling */
    }
    button:hover, a:hover {
        background-color: #16a085; /* Darker Sea Green */
        transform: scale(1.05);
    }
    button:active, a:active {
        background-color: #149174; /* Even Darker Sea Green */
        transform: scale(0.98);
    }
    .button-container {
        text-align: center;
        display: flex;
        justify-content: center;
        gap: 10px; /* Space between buttons */
        flex-wrap: wrap; /* Allow buttons to wrap on smaller screens */
    }
    .button-container .btn-primary {
        background-color: #1abc9c;
        border-color: #1abc9c;
    }
    .button-container .btn-primary:hover {
        background-color: #16a085;
        border-color: #16a085;
    }
    .button-container .btn-home {
        background-color: #1abc9c; /* Blue color for Home button */
        border-color: #3498db;
    }
    .button-container .btn-home:hover {
        background-color: #16a085;
        border-color: #2980b9;
    }
    /* Ensure the form and its contents are responsive */
    @media (max-width: 600px) {
        .form-group input[type="text"],
        .form-group select,
        .form-group input[type="date"] {
            font-size: 14px; /* Adjust font size for smaller screens */
            padding: 10px; /* Adjust padding for smaller screens */
        }
        button, a {
            font-size: 14px; /* Adjust font size for smaller screens */
            padding: 10px 20px; /* Adjust padding for smaller screens */
        }
    }
</style>
</head>
<body>
    <div class="container">
        <h2>View Transaction</h2>
        <form action="ViewTransactions" method="post">
            <div class="form-group">
                <label for="search">Search</label>
                <input type="text" id="search" name="search" placeholder="Search by account number or type" value="${param.search}">
            </div>
            <div class="form-group">
                <label for="type">Transaction Type</label>
                <select id="type" name="type">
                    <option value="">All Types</option>
                    <option value="Credit" ${param.type == 'Credit' ? 'selected' : ''}>Credit</option>
                    <option value="Debit" ${param.type == 'Debit' ? 'selected' : ''}>Debit</option>
                    <option value="Transfer" ${param.type == 'Transfer' ? 'selected' : ''}>Transfer</option>
                </select>
            </div>
            <div class="form-group">
                <label for="startDate">Start Date</label>
                <input type="date" id="startDate" name="startDate" value="${param.startDate}">
            </div>
            <div class="form-group">
                <label for="endDate">End Date</label>
                <input type="date" id="endDate" name="endDate" value="${param.endDate}">
            </div>
            <div class="button-container">
                <button type="submit" class="btn btn-primary">View the Transaction</button>
                <a href="Admin.jsp" class="btn btn-home">Home</a>
            </div>
        </form>
    </div>
</body>
</html>
