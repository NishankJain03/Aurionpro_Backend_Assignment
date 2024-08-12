<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
            width: 320px;
        }
        h2 {
            text-align: center;
            color: #2c3e50; /* Slate */
            margin-bottom: 20px;
        }
        input[type="number"],
        input[type="text"],
        button {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            box-sizing: border-box;
            border-radius: 5px;
            border: 1px solid #ddd;
        }
        input[type="number"],
        input[type="text"] {
            border: 1px solid #ccc;
        }
        button {
            background-color: #1abc9c; /* Sea Green */
            color: white;
            border: none;
            cursor: pointer;
            font-weight: bold;
        }
        button:hover {
            background-color: #16a085; /* Darker Sea Green */
        }
        .note {
            font-size: 0.875rem;
            color: #888;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Forgot Password</h2>
        <form action="ForgotPasswordServlet" method="post">
            <input type="number" name="accountNumber" placeholder="Enter the account number" required>
            <input type="text" name="newPassword" placeholder="Enter the new password" required>
            <input type="text" name="reTypePassword" placeholder="Retype the new password" required>
            <button type="submit">Submit</button>
        </form>
        <p class="note">Please ensure your passwords match.</p>
    </div>
</body>
</html>
