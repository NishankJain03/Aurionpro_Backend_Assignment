<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f7fa; /* Light grey background */
            margin: 0;
            padding: 0;
        }
        .navbar {
            background-color: #2c3e50; /* Dark Slate Background */
        }
        .navbar-brand {
            color: #ecf0f1 !important; /* Light Text Color */
        }
        .navbar-nav {
            flex-direction: row;
        }
        .navbar-nav .nav-link {
            color: #1abc9c !important; /* Sea Green for Links */
            padding: 0.5rem 1rem;
        }
        .navbar-nav .nav-link:hover {
            color: #16a085 !important; /* Darker Sea Green on Hover */
        }
        .navbar-nav.ms-auto {
            margin-left: auto;
        }
        .container {
            max-width: 800px; /* Increased max-width */
            width: 100%;
            padding: 20px;
            background: #ffffff; /* White background for the card */
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin: 20px auto;
        }
        .btn {
            padding: 10px 20px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
            text-decoration: none; /* Remove underline from links */
        }
        .btn-primary {
            color: #fff;
            background-color: #1abc9c; /* Sea Green */
        }
        .btn-primary:hover {
            background-color: #16a085; /* Darker Sea Green */
        }
        .btn-success {
            color: #fff;
            background-color: #2ecc71; /* Emerald */
        }
        .btn-success:hover {
            background-color: #27ae60; /* Darker Emerald */
        }
        .btn-warning {
            color: #fff;
            background-color: #f39c12; /* Sunflower */
        }
        .btn-warning:hover {
            background-color: #d35400; /* Pumpkin */
        }
    </style>
    <script>
        function redirectWithAction(action) {
            const form = document.createElement('form');
            form.method = 'POST';
            form.action = 'Customer';
            
            const hiddenField = document.createElement('input');
            hiddenField.type = 'hidden';
            hiddenField.name = 'action';
            hiddenField.value = action;
            form.appendChild(hiddenField);
            
            document.body.appendChild(form);
            form.submit();
        }
    </script>
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Customer Dashboard</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="#" onclick="redirectWithAction('passbook')">Passbook</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" onclick="redirectWithAction('newTransaction')">New Transaction</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" onclick="redirectWithAction('editProfile')">Edit Profile</a>
                        </li>
                    </ul>
                    <a class="btn btn-outline-light ms-2" href="Login.jsp">Logout</a>
                </div>
            </div>
        </nav>
    </header>
    <div class="container">
        <h4 class="card-title text-center mb-4">Customer Dashboard</h4>
        <div class="text-center">
            <p>Welcome, ${username}</p>
        </div>
    </div>
</body>
</html>
