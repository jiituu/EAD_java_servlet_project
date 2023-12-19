<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Page</title>
<link rel="stylesheet" href="css/bootstrap.css">
<style>
.error-message {
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 600px;
	padding: 20px;
	border: 1px solid #dc3545;
	border-radius: 5px;
	background-color: #f8d7da;
	text-align: center;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

.success-message {
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 600px;
	padding: 20px;
	border: 1px solid #28a745;
	border-radius: 5px;
	background-color: #dff0d8;
	text-align: center;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); . success-message p {
	font-size : 18px;
	margin-bottom: 0;
}

.close-btn {
	position: absolute;
	top: 10px;
	right: 10px;
	color: #6c757d;
	font-size: 20px;
	cursor: pointer;
}

.close-btn:hover {
	color: #333;
	cursor: pointer;
}
</style>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand"
				href="/TaskManagementSystem/Userdashboard?userId=<%=session.getAttribute("userId")%>">Task
				Manager</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="/TaskManagementSystem/Userdashboard?userId=<%=session.getAttribute("userId")%>">Userdashboard</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="/TaskManagementSystem/Createtask.jsp">Add Task</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="/TaskManagementSystem/User.jsp">Profile</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<%
	String successMessage = (String) request.getAttribute("successMessage");
	String errorMessage = (String) request.getAttribute("errorMessage");
	%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6">
				<h2>User</h2>
				<form action="user" method="post">
					<input type="hidden" name="username"
						value="<%=session.getAttribute("userName")%>">
					<div class="form-group">
						<label for="newUsername">Username</label> <input type="text"
							class="form-control" id="newUsername" name="newUsername"
							value="<%=session.getAttribute("userName")%>">
					</div>


					<button type="submit" class="btn btn-primary">Change
						Username</button>
				</form>
			</div>
			<div class="col-md-6">
				<h2>Change Password</h2>
				<form action="user" method="post">
					<div class="form-group">
						<input type="hidden" id="username" name="username"
							value="<%=session.getAttribute("userName")%>">
					</div>
					<div class="form-group">
						<label for="currentPassword">Current Password:</label> <input
							type="password" class="form-control" id="currentPassword"
							name="currentPassword" required>
					</div>
					<div class="form-group">
						<label for="newPassword">New Password:</label> <input
							type="password" class="form-control" id="newPassword"
							name="newPassword" required>
					</div>
					<button type="submit" class="btn btn-primary">Change
						Password</button>
				</form>
			</div>
		</div>
	</div>
	<%
	if (errorMessage != null) {
	%>
	<div class="error-message">
		<p><%=errorMessage%></p>
		<span class="close-btn">&times;</span>
	</div>
	<%
	}
	if (successMessage != null) {
	%>
	<div class="success-message">
		<p><%=successMessage%></p>
		<span class="close-btn">&times;</span>
	</div>

	<%
	}
	%>


	<script>
		document
				.querySelector('.close-btn')
				.addEventListener(
						'click',
						function() {
							document.querySelector('.success-message').style.display = 'none';
						});
	</script>

</body>
</html>