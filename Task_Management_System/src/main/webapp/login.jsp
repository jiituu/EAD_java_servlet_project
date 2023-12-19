<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login</title>
<link rel="stylesheet" href="css/bootstrap.css">
<style>
body {
	background-color: #f8f9fa;
}

.card {
	width: 500px;
	margin: 0 auto;
	border: none;
	border-radius: 10px;
	box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
}

.card-header {
	background-color: #007bff;
	border-radius: 10px 10px 0 0;
	padding: 40px;
	text-align: center;
}

.card-header h2 {
	color: #fff;
	font-size: 32px;
	font-weight: bold;
	margin: 0;
}

.card-body {
	padding: 40px;
}

.form-group label {
	font-weight: bold;
}

.form-control {
	border-radius: 5px;
	padding: 10px;
}

.btn-primary {
	background-color: #007bff;
	border: none;
	border-radius: 5px;
	padding: 10px 20px;
	font-size: 16px;
	font-weight: bold;
	transition: background-color 0.3s;
}

.btn-primary:hover {
	background-color: #0069d9;
}

.register-link {
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

.login-title {
	font-size: 28px;
	font-weight: bold;
	margin-bottom: 20px;
}

.login-subtitle {
	font-size: 16px;
	color: #6c757d;
	margin-bottom: 40px;
}

.login-form {
	max-width: 600px;
	width: 100%;
}

.login-form .form-control {
	height: 50px;
}

.login-form .btn-primary {
	width: 100%;
}

.login-form .register-link {
	margin-top: 30px;
	font-size: 14px;
}

.login-form .register-link a {
	color: #6c757d;
}

.login-form .register-link a:hover {
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
				<h2 class="display-4">Login</h2>
			</div>
			<div class="card-body">
				<form class="login-form" action="login" method="post">
					<h4 class="login-title">Welcome Back!</h4>

					<div class="form-group">
						<label for="username">Username</label> <input type="text"
							class="form-control" id="username" name="username" required>
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							class="form-control" id="password" name="password" required>
					</div>
					<button type="submit" class="btn btn-primary">Login</button>
					<div class="register-link">
						<p>
							Don't have an account? <a href="register.jsp">Create an
								account</a>
						</p>
						<%
						if (errorMessage != null) {
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
			<div class="card-footer">
				<p class="text-center">© 2023 EAD task management project. All
					rights reserved.</p>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS and Popper.js (if needed) -->
	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>