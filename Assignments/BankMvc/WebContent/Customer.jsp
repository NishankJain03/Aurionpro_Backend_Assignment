<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f4f7fa; /* Light grey background */
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
        padding: 20px;
        background: #ffffff; /* White background for the card */
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
    .btn {
        padding: 10px 20px;
        font-size: 16px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s;
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
</style>
</head>
<body>
    <div class="container">
        <h4 class="card-title text-center">Customer Dashboard</h4>
        <form action="CustomerServlet" method="post">
            <div class="form-group text-center mb-3">
                <button type="submit" name="action" value="passbook" class="btn btn-primary btn-lg">Passbook</button>
            </div>
            <div class="form-group text-center mb-3">
                <button type="submit" name="action" value="newTransaction" class="btn btn-success btn-lg">New Transaction</button>
            </div>
            <div class="form-group text-center mb-3">
                <button type="submit" name="action" value="editProfile" class="btn btn-warning btn-lg">Edit Profile</button>
            </div>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b4gtT2xkQ6D4ex9d0x4uH1Y5t4OGyQf8G5nfhgW/DhWeFvTEB9KPf52y5hcxSbxjT" crossorigin="anonymous"></script>
</body>
</html>
