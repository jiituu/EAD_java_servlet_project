<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration form</title>
</head>
<body>
		<%@ include file="header.jsp" %>
	<h2> Registration Form</h2>
	<form action="Registration" method="post">
		Name: <input type="text" name="name" value="<%=
		request.getParameter("name") %>"><br>
		Email: <input type="text" name="email" value="<%=
		request.getParameter("email") %>"><br>
		Password: <input type="password" name="password"><br>
		<input type="submit" value="Register">
	</form>

</body>
</html>