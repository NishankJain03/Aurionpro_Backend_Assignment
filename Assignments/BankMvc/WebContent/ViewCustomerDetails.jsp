<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Customer Details</title>
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
    .account-number {
        margin-top: 20px;
        font-size: 20px;
        font-weight: bold;
        color: #28a745;
        text-align: center;
    }
    .back-link {
        display: block;
        margin-top: 20px;
        font-size: 16px;
        color: #fffff;
        text-decoration: none;
    }
    .back-link:hover {
        text-decoration: underline;
    }
    .form-container {
        margin-top: 30px;
        text-align: center;
    }
    form {
        display: flex;
        flex-direction: column;
        align-items: center;
        gap: 15px;
    }
      p {
        font-size: 18px;
        color: #555;
        margin: 10px 0;
        text-align: left;
    }
    
</style>
</head>
<body>
    <div class="container">
        <c:if test="${not empty customer}">
            <h2>Customer Details</h2>
            <p><strong>ID:</strong> ${customer.getCustomerID()}</p>
            <p><strong>First Name:</strong> ${customer.getFirstName()}</p>
            <p><strong>Last Name:</strong> ${customer.getLastName()}</p>
            <p><strong>Email:</strong> ${customer.getEmail()}</p>

            <!-- Form to generate an account number -->
            <div class="form-container">
                <form action="AddBankAccount" method="post">
                    <input type="hidden" name="action" value="generateAccountNumber">
                    <input type="hidden" name="customerId" value="${customer.getCustomerID()}">
                    <button type="submit">Generate Account Number</button>
                </form>

                <c:if test="${not empty accountNumber}">
                    <p class="account-number">Generated Account Number: ${accountNumber}</p>
                </c:if>
            </div>
        </c:if>

        <!-- Link to return to the previous page -->
        <a href="Admin.jsp" class="back-link">Back to Admin Page</a>
    </div>
</body>
</html>
