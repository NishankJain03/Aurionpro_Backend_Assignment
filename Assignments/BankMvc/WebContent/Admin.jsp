<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>    
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #ecf0f1; /* Off White Background */
            margin: 0;
        }
        .navbar {
            background-color: #2c3e50; /* Dark Slate Background */
        }
        .navbar-brand, .nav-link {
            color: #ecf0f1 !important; /* Light Text Color */
        }
        .navbar-brand:hover, .nav-link:hover {
            color: #bdc3c7 !important; /* Light Gray for Hover */
        }
        .navbar-nav {
            flex-direction: row;
        }
        .navbar-nav .nav-link {
            padding: 0.5rem 1rem;
        }
        .navbar-toggler {
            width: 50px;
            height: 50px;
            padding: 0;
            border-radius: 50%;
            transition: 0.3s ease-in-out;
            flex-shrink: 0;
        }
        .card {
            display: flex;
            flex-direction: column;
            margin: 20px 0; /* Increase margin to space out the cards */
            background-color: #ffffff; /* White Background for Cards */
            border: 1px solid #dcdcdc; /* Light Gray Border */
            border-radius: 10px;
            min-height: 300px; /* Increase minimum height of cards */
        }
        .card-body {
            flex: 1;
            display: flex;
            flex-direction: column;
            justify-content: center;
            padding: 20px; /* Increase padding for more content space */
        }
        .btn-primary {
            background-color: #1abc9c; /* Sea Green Background */
            border-color: #1abc9c; /* Match Border Color */
        }
        .btn-primary:hover {
            background-color: #16a085; /* Darker Sea Green on Hover */
            border-color: #16a085; /* Match Border Color */
        }
        .container {
            max-width: 1200px;
            margin: 20px auto;
            padding: 20px;
        }
        footer {
            margin-top: 20px;
            color: #777;
            text-align: center;
        }
    </style>
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Admin</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <!-- Add any additional nav items here if needed -->
                    </ul>
                    <a class="btn btn-outline-light ms-2" href="Login.jsp">Logout</a>
                </div>
            </div>
        </nav>
    </header>
    <div class="container">
        <h1 class="mt-5 text-center">Welcome, ${username}</h1>
        <div class="row">
            <div class="col-md-3">
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">Add New Customer</h5>
                        <p class="card-text">Create a new customer entry in the system.</p>
                        <a href="AddCustomer" class="btn btn-primary">Go to Add</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">Add Bank Account</h5>
                        <p class="card-text">Add a new bank account to the system.</p>
                        <a href="AddAccount" class="btn btn-primary">Go to Add</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">View Customer</h5>
                        <p class="card-text">View details of existing customers.</p>
                        <a href="ViewCustomer" class="btn btn-primary">Go to View</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">View Transaction</h5>
                        <p class="card-text">Check and manage transactions in the system.</p>
                        <a href="ViewTransaction" class="btn btn-primary">Go to View</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer>
        <p>&copy; 2024 Your Company. All rights reserved.</p>
    </footer>
</body>
</html>
