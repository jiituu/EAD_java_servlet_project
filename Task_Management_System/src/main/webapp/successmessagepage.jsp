<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.taskmanager.Task"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
<style>
.success-message {
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 400px;
	padding: 20px;
	border: 1px solid #28a745;
	border-radius: 5px;
	background-color: #dff0d8;
	text-align: center;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

.success-message h2 {
	color: #28a745;
	font-size: 24px;
	margin-bottom: 10px;
}

.success-message p {
	font-size: 18px;
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
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="/TaskManagementSystem/Userdashboard?userId=<%=session.getAttribute("userId")%>">Task Manager</a>
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
						href="/TaskManagementSystem/addTask.jsp">Add Task</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/TaskManagementSystem/User.jsp">Profile</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<%
	String successMessage = (String) request.getAttribute("successMessage");
	%>
	<div class="success-message">
		<h2>Success!</h2>
		<p><%=successMessage%></p>
		<span class="close-btn">&times;</span>
	</div>

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