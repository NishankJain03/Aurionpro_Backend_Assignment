<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edit Profile</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
    body {
        background-color: #ecf0f1; /* Off White */
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }
    .card {
        border-radius: 8px;
        overflow: hidden;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        background-color: #ffffff; /* White */
    }
    .card-body {
        padding: 20px;
    }
    .form-group label {
        font-weight: 600;
        color: #343a40; /* Dark Slate */
    }
    .btn-primary {
        background-color: #1abc9c; /* Sea Green */
        border: none;
        transition: background-color 0.3s, transform 0.2s;
    }
    .btn-primary:hover {
        background-color: #16a085; /* Darker Sea Green */
        transform: scale(1.05);
    }
    .btn-secondary {
        background-color: #bdc3c7; /* Light Slate */
        border: none;
        transition: background-color 0.3s, transform 0.2s;
    }
    .btn-secondary:hover {
        background-color: #95a5a6; /* Darker Slate */
        transform: scale(1.05);
    }
    .btn {
        border-radius: 5px;
    }
    .text-center {
        margin-top: 20px;
    }
    .error {
        color: #e74c3c; /* Bright red */
        font-size: 0.875em;
    }
</style>
<script>
    function validateForm() {
        const firstName = document.getElementById('firstName').value.trim();
        const lastName = document.getElementById('lastName').value.trim();
        const password = document.getElementById('password').value.trim();
        const errors = [];

        // Validation for first name and last name
        if (!firstName || firstName.length < 2) {
            errors.push('First name must be at least 2 characters long.');
        }
        if (!lastName || lastName.length < 2) {
            errors.push('Last name must be at least 2 characters long.');
        }

        // Validation for password
        const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
        if (!passwordPattern.test(password)) {
            errors.push('Password must be at least 8 characters long, include one uppercase letter, one lowercase letter, one digit, and one special character.');
        }

        // Display errors if any
        if (errors.length > 0) {
            document.getElementById('errorMessages').innerHTML = errors.join('<br>');
            return false;
        }

        return true;
    }
</script>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center align-items-center" style="height: 100vh;">
            <div class="col-md-8 col-lg-6">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title text-center mb-4">Edit Profile</h4>
                        <form action="UpdateProfile" method="get" onsubmit="return validateForm()">
                            <div id="errorMessages" class="error mb-3"></div>
                            <div class="form-group mb-3">
                                <label for="firstName">First Name:</label>
                                <input type="text" id="firstName" name="firstName" class="form-control" placeholder="Enter your first name" required>
                            </div>
                            <div class="form-group mb-3">
                                <label for="lastName">Last Name:</label>
                                <input type="text" id="lastName" name="lastName" class="form-control" placeholder="Enter your last name" required>
                            </div>
                            <div class="form-group mb-3">
                                <label for="password">Password:</label>
                                <input type="password" id="password" name="password" class="form-control" placeholder="Enter your password" required>
                            </div>
                            <div class="form-group text-center">
                                <button type="submit" class="btn btn-primary">Update</button>
                                <a href="Customer.jsp" class="btn btn-secondary ms-2">Cancel</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b4gtT2xkQ6D4ex9d0x4uH1Y5t4OGyQf8G5nfhgW/DhWeFvTEB9KPf52y5hcxSbxjT" crossorigin="anonymous"></script>
</body>
</html>
