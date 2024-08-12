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
        height: 100vh;
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
    p {
        font-size: 18px;
        color: #555;
        margin-bottom: 30px;
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
</style>
</head>
<body>
    <div class="container">
        <h2>View Transaction</h2>
        <p>Click the button below to view the transaction details.</p>
        <form action="ViewTransactionAdminServlet" method="post">
            <button type="submit">View the Transaction</button>
        </form>
    </div>
</body>
</html>
