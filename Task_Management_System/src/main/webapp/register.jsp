<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Registration</title>
<link rel="stylesheet" href="css/bootstrap.css">
<style>
body {
    background-color: #f8f9fa;
}

.card {
    max-width: 500px;
    margin: 0 auto;
    border: none;
    border-radius: 10px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.card-header {
    background-color: #007bff;
    border-radius: 10px 10px 0 0;
    padding: 30px; /* Reduced padding */
    text-align: center;
}

.card-header h2 {
    color: #fff;
    font-size: 28px; /* Slightly reduced font size */
    font-weight: bold;
    margin: 0;
}

.card-body {
    padding: 30px; /* Reduced padding */
}

.form-group label {
    font-weight: bold;
}

.form-control {
    border-radius: 5px;
    padding: 12px; /* Slightly increased padding */
}

.btn-primary {
    background-color: #007bff;
    border: none;
    border-radius: 5px;
    padding: 12px 24px; /* Adjusted padding */
    font-size: 16px;
    font-weight: bold;
    transition: background-color 0.3s;
}

.btn-primary:hover {
    background-color: #0069d9;
}

.login-link {
    text-align: center;
    margin-top: 20px;
}

.card-footer {
    background-color: #f8f9fa;
    border-top: none;
    border-radius: 0 0 10px 10px;
    padding: 20px;
}

.card-footer p {
    margin-bottom: 0;
}

.bg-primary {
    background-color: #007bff;
}

.text-white {
    color: #fff;
}

.container {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100vh;
}

.register-title {
    font-size: 26px; /* Slightly reduced font size */
    font-weight: bold;
    margin-bottom: 20px;
}

.register-form {
    max-width: 400px;
    width: 100%;
}

.register-form .form-control {
    height: 46px; /* Slightly reduced height */
}

.register-form .btn-primary {
    width: 100%;
}

.register-form .login-link {
    margin-top: 25px; /* Adjusted margin */
    font-size: 14px;
}

.register-form .login-link a {
    color: #6c757d;
}

.register-form .login-link a:hover {
    color: #007bff;
}

</style>
</head>
<body>

	<%
	String errorMessage = (String) request.getAttribute("errorMessage");
	%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2 class="display-4">Registration</h2>
			</div>
			<div class="card-body">
				<form class="register-form" action="register" method="post">
					<h3 class="register-title">Create an Account</h3>
					<div class="form-group">
						<label for="username">Username</label> <input type="text"
							class="form-control" id="username" name="username" required>
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							class="form-control" id="password" name="password" required>
					</div>
					<button type="submit" class="btn btn-primary">Register</button>
					<div class="login-link">
						<p>
							Already have an account? <a href="login.jsp">Login</a>
						</p>
						<%if (errorMessage != null) {
						%>
						<div class="alert alert-danger">
							<p><%=errorMessage%></p>
						</div>
						<% 
						}
						%>
					</div>
				</form>
			</div>
		</div>
	</div>





	<!-- Bootstrap JS and Popper.js (if needed) -->
	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>