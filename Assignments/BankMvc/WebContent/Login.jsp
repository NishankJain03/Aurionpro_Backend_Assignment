<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.5.0/font/bootstrap-icons.min.css">
<title>Secure Bank Login</title>
<style>
    body {
        background-color: #ecf0f1;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }
    .split-screen {
        display: flex;
        height: 100vh;
    }
    .welcome-section {
        background: linear-gradient(to right, #2c3e50, #1abc9c);
        color: #ffffff;
        padding: 40px;
        flex: 1;
        display: flex;
        flex-direction: column;
        justify-content: center;
        text-align: left;
    }
    .welcome-text {
        max-width: 400px;
    }
    .login-section {
        flex: 1;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    .login-card {
        background: #ffffff;
        border: none;
        border-radius: 10px;
        box-shadow: 0 8px 16px rgba(0,0,0,0.1);
        width: 100%;
        max-width: 320px;
        padding: 20px;
    }
    .btn-primary {
        background-color: #1abc9c;
        border: none;
    }
    .btn-primary:hover {
        background-color: #16a085;
    }
    .form-control {
        border-radius: 5px;
    }
    .form-icon {
        color: #2c3e50;
    }
    .forgot-password {
        margin-top: 15px;
        font-size: 0.875rem;
    }
    .forgot-password a {
        color: #2c3e50;
        text-decoration: none;
    }
    .forgot-password a:hover {
        text-decoration: underline;
        color: #1abc9c;
    }
</style>
</head>
<body>
    <div class="split-screen">
        <div class="welcome-section">
            <div class="welcome-text">
                <h1>Welcome to Secure Bank</h1>
                <p>Efficiently manage your finances with confidence and ease.</p>
            </div>
        </div>
        <div class="login-section">
            <div class="card login-card">
                <div class="card-body">
                    <h4 class="card-title mb-4">Account Login</h4>
                    <form action="LoginServlet" method="post">
                        <div class="mb-3 position-relative">
                            <i class="bi bi-person-fill form-icon"></i>
                            <input type="text" id="username" name="username" class="form-control" placeholder="Username" required>
                        </div>
                        <div class="mb-3 position-relative">
                            <i class="bi bi-key-fill form-icon"></i>
                            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
                        </div>
                        <div class="mb-3">
                            <select id="loginType" name="loginType" class="form-select">
                                <option value="Admin">Admin</option>
                                <option value="Customer">Customer</option>
                            </select>
                        </div>
                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-primary">Login</button>
                            <button type="reset" class="btn btn-secondary">Reset</button>
                        </div>
                        <div class="forgot-password">
                            <a href="ForgotPassword.jsp">Forgot Password?</a>
                        </div>
                        <% String message = request.getParameter("message"); %>
							<% if ("passwordUpdated".equals(message)) { %>
   								 <p>Password updated successfully!</p>
						<% } %>
                        
                    </form>
                </div>
            </div>
        </div>
    </div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNzRxqpPx6+qn9hC8xCw3rV8UauA7Rk7lUE/59M7NHw4+4xE4UV7jUPB9svCIOU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVUAyZwlQ73pXmR+JbxtB1D3C1fA2eB2zxW5ZyTxC0M34b06AczjGh97nnFz8Vx7" crossorigin="anonymous"></script>
</body>
</html>
