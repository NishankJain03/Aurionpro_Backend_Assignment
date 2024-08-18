<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>View Customer Button</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f4f7fa; /* Light slate background */
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        height: 100vh;
    }
    .navbar {
        background-color: #1abc9c; /* Sea Green */
        padding: 10px;
        display: flex;
        justify-content: center;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .navbar a {
        color: #ffffff;
        text-decoration: none;
        padding: 12px 20px;
        font-size: 16px;
        transition: background-color 0.3s, transform 0.2s;
    }
    .navbar a:hover {
        background-color: #16a085; /* Darker Sea Green */
        transform: scale(1.05);
    }
    .navbar a:active {
        background-color: #149174; /* Even Darker Sea Green */
        transform: scale(0.98);
    }
    .navbar .home, .navbar .logout {
        margin-left: 10px; /* Add some space between Home and Logout buttons */
    }
    .container {
        background: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        text-align: center;
        width: 100%;
        max-width: 500px; /* Adjusted for consistency */
        margin: auto;
        margin-top: 20px;
    }
    h2 {
        color: #333;
        margin-bottom: 20px;
        font-size: 24px;
    }
    button {
        padding: 12px 20px;
        font-size: 16px;
        color: #ffffff;
        background-color: #1abc9c; /* Sea Green */
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s, transform 0.2s;
    }
    button:hover {
        background-color: #16a085; /* Darker Sea Green */
        transform: scale(1.05);
    }
    button:active {
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
    
    /* Style for the search form container */
    .container form {
        display: flex;
        flex-direction: column;
        align-items: center;
        margin-bottom: 20px;
    }

    /* Style for the search input field */
    .container input[type="text"] {
        padding: 12px;
        font-size: 16px;
        border: 1px solid #ddd;
        border-radius: 5px;
        width: 100%;
        max-width: 400px; /* Adjust as needed */
        box-sizing: border-box; /* Ensures padding and border are included in width */
        margin-bottom: 10px;
    }

    /* Style for the search button */
    .container button[type="submit"] {
        padding: 12px 20px;
        font-size: 16px;
        color: #ffffff;
        background-color: #1abc9c; /* Sea Green */
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s, transform 0.2s;
        margin-top: 10px; /* Add some space between the search input and button */
    }

    /* Hover and active states for the search button */
    .container button[type="submit"]:hover {
        background-color: #16a085; /* Darker Sea Green */
        transform: scale(1.05);
    }

    .container button[type="submit"]:active {
        background-color: #149174; /* Even Darker Sea Green */
        transform: scale(0.98);
    }
    
</style>

</head>
<body>
    <div class="navbar">
        <form action="ViewCustomerDetails" method="post" style="margin: 0;">
            <input type="hidden" name="action" value="firstName">
            <button type="submit">Sort By First Name</button>
        </form>
        <form action="ViewCustomerDetails" method="post" style="margin: 0;">
            <input type="hidden" name="action" value="lastName">
            <button type="submit">Sort By Last Name</button>
        </form>
        <form action="ViewCustomerDetails" method="post" style="margin: 0;">
            <input type="hidden" name="action" value="accountNumber">
            <button type="submit">Sort By Account Number</button>
        </form>
        <form action="ViewCustomerDetails" method="post" style="margin: 0;">
            <input type="hidden" name="action" value="balance">
            <button type="submit">Sort By Balance</button>
        </form>
        <a href="Admin.jsp" class="home">Home</a>
        <a href="Login.jsp" class="logout">Logout</a>
    </div>
    <div class="container">
        <h2>View Customer Details</h2>
        <form action="ViewCustomerDetails" method="post">
            <input type="text" name="searchTerm" placeholder="Enter customer name or account number" required>
            <button type="submit" name="action" value="search">Search</button>
        </form>
        <p>Click the button below to view the details of the customer.</p>
        <form action="ViewCustomerDetails" method="post">
            <input type="hidden" name="action" value="viewDetails">
            <button type="submit">View Customer Details</button>
        </form>
    </div>
</body>
</html>
