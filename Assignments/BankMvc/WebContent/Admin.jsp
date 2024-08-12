<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgp3LIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #ecf0f1; /* Off White */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #ffffff; /* White */
            padding: 40px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            width: 600px;
            text-align: center;
        }
        h1 {
            color: #2c3e50; /* Slate */
            margin-bottom: 20px;
        }
        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
            align-items: center;
        }
        button {
    padding: 10px 20px; /* Adjust padding to control the size */
    font-size: 16px; /* Standard font size for all buttons */
    width: 200px; /* Ensures all buttons have the same width */
    height: 50px; /* Ensures all buttons have the same height */
    color: white;
    background-color: #1abc9c; /* Sea Green */
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;
}
        button:hover {
            background-color: #16a085; /* Darker Sea Green */
        }
        footer {
            margin-top: 20px;
            color: #777;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Admin Dashboard</h1>
        <form action="AdminServlet" method="post">
            <button type="submit" name="action" value="addCustomer">Add New Customer</button>
            <button type="submit" name="action" value="addAccount">Add Bank Account</button>
            <button type="submit" name="action" value="viewCustomer">View Customer</button>
            <button type="submit" name="action" value="viewTransaction">View Transaction</button>
        </form>
        <footer>
            <p>&copy; 2024 Your Company. All rights reserved.</p>
        </footer>
    </div>
</body>
</html>
