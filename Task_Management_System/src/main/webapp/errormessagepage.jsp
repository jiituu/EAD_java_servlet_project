<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
<style>
    .error-message {
        position: fixed;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        width: 400px;
        padding: 30px; 
        border: 2px solid #d9534f;
        border-radius: 8px;
        background-color: #f2dede; 
        text-align: center;
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.3); 
    }

    .error-message h2 {
        color: #d9534f; 
        font-size: 26px;
        margin-bottom: 15px; 
    }

    .error-message p {
        font-size: 20px;
        margin-bottom: 10px; 
    }

    .close-btn {
        position: absolute;
        top: 15px; 
        right: 15px; 
        color: #6c757d;
        font-size: 24px;
        cursor: pointer;
    }

    .close-btn:hover {
        color: #333;
    }
</style>

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand" href="/TaskManagementSystem/Userdashboard?userId=<%=session.getAttribute("userId")%>">Task Manager</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/TaskManagementSystem/Userdashboard?userId=<%=session.getAttribute("userId")%>">Userdashboard</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/TaskManagementSystem/addTask.jsp">Add Task</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/TaskManagementSystem/User.jsp">Profile</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

	<%
	String errorMessage = (String) request.getAttribute("errorMessage");
	%>
	<div class="error-message">
		<h2>Error!</h2>
		<p><%=errorMessage%></p>
		<span class="close-btn">&times;</span>
	</div>

	<script>
		document
				.querySelector('.close-btn')
				.addEventListener(
						'click',
						function() {
							document.querySelector('.error-message').style.display = 'none';
						});
	</script>
</body>
</html>