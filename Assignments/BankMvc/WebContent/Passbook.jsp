<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Passbook</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f4f7fa;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }
    .container {
        background: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        width: 100%;
        max-width: 600px;
        overflow: auto;
    }
    h2 {
        color: #2c3e50;
        margin-bottom: 20px;
        font-size: 28px;
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
        padding: 11px;
    }
    button, a {
        padding: 12px 24px;
        font-size: 16px;
        color: #ffffff;
        background-color: #1abc9c;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s, transform 0.2s;
        text-decoration: none;
        display: inline-block;
    }
    button:hover, a:hover {
        background-color: #16a085;
        transform: scale(1.05);
    }
    button:active, a:active {
        background-color: #149174;
        transform: scale(0.98);
    }
    .button-container {
        text-align: center;
        display: flex;
        justify-content: center;
        gap: 10px;
        flex-wrap: wrap;
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
        background-color: #3498db;
        border-color: #3498db;
    }
    .button-container .btn-home:hover {
        background-color: #2980b9;
        border-color: #2980b9;
    }
    @media (max-width: 600px) {
        .form-group input[type="text"],
        .form-group select,
        .form-group input[type="date"] {
            font-size: 14px;
            padding: 10px;
        }
        button, a {
            font-size: 14px;
            padding: 10px 20px;
        }
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Passbook</h2>
        <form action="Passbook" method="get">
            <div class="form-group">
                <label for="type">Transaction Type</label>
                <select id="type" name="type">
                    <option value="">All Types</option>
                    <option value="Credit" ${type == 'Credit' ? 'selected' : ''}>Credit</option>
                    <option value="Debit" ${type == 'Debit' ? 'selected' : ''}>Debit</option>
                    <option value="Transfer" ${type == 'Transfer' ? 'selected' : ''}>Transfer</option>
                </select>
            </div>
            <div class="form-group">
                <label for="startDate">Start Date</label>
                <input type="date" id="startDate" name="startDate" value="${startDate}">
            </div>
            <div class="form-group">
                <label for="endDate">End Date</label>
                <input type="date" id="endDate" name="endDate" value="${endDate}">
            </div>
            <div class="form-group">
                <label for="sortBy">Sort By</label>
                <select id="sortBy" name="sortBy">
                    <option value="TransactionDate" ${sortBy == 'TransactionDate' ? 'selected' : ''}>Date</option>
                    <option value="Amount" ${sortBy == 'Amount' ? 'selected' : ''}>Amount</option>
                </select>
            </div>
            <div class="form-group">
                <label for="sortOrder">Sort Order</label>
                <select id="sortOrder" name="sortOrder">
                    <option value="ASC" ${sortOrder == 'ASC' ? 'selected' : ''}>Ascending</option>
                    <option value="DESC" ${sortOrder == 'DESC' ? 'selected' : ''}>Descending</option>
                </select>
            </div>
            <div class="button-container">
                <button type="submit" class="btn btn-primary">View Passbook</button>
                <a href="Customer" class="btn btn-home">Home</a>
            </div>
        </form>
    </div>
</body>
</html>
