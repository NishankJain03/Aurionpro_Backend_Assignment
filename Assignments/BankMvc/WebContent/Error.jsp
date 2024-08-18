<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f7f6;
            color: #333;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            max-width: 500px;
            width: 100%;
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .error-message {
            font-size: 1.2em;
            color: #e74c3c; /* Bright red for error messages */
            margin-bottom: 20px;
        }
        .button {
            display: inline-block;
            padding: 12px 24px;
            font-size: 16px;
            color: #fff;
            background-color: #1abc9c; /* Blue background for buttons */
            border: none;
            border-radius: 5px;
            text-decoration: none;
            transition: background-color 0.3s, transform 0.2s;
        }
        .button:hover {
            background-color: #16a085; /* Darker blue on hover */
            transform: scale(1.05);
        }
        .button:active {
            background-color: #149174; /* Even darker blue on click */
            transform: scale(0.98);
        }
        .home-link {
            margin-left: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="error-message">
            <p><%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "An unexpected error occurred. Please try again later." %></p>
        </div>
        <a href="javascript:history.back()" class="button">Go Back</a>
        <a href="Login.jsp" class="button home-link">Home Page</a>
    </div>
</body>
</html>
