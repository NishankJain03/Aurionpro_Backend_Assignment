<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transaction Success</title>
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
    .btn-custom, a {
        padding: 12px 20px;
        font-size: 16px;
        color: #ffffff;
        background-color: #1abc9c; /* Sea Green */
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s, transform 0.2s;
    }
    .btn-custom:hover, a:hover {
        background-color: #16a085; /* Darker Sea Green */
        transform: scale(1.05);
    }
   .btn-custom:active, a:active {
        background-color: #149174; /* Even Darker Sea Green */
        transform: scale(0.98);
    }
        .success-icon {
            font-size: 100px;
            color: #28a745;
        }
        .btn-custom {
            background-color: #007bff;
            color: white;
            border-radius: 20px;
        }
        .btn-custom:hover {
            background-color: #0056b3;
            color: white;
        }
    </style>
</head>
<body>
    <div class="container text-center">
        <div class="success-icon">
            <i class="bi bi-check-circle"></i>
        </div>
        <h1 class="display-4 text-success">Transaction Successful</h1>
        <p class="lead">Your transaction was completed successfully. Thank you for using our services!</p>
        <a href="CustomerServlet?action=passbook" class="btn btn-custom btn-lg">Go to Passbook</a>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
