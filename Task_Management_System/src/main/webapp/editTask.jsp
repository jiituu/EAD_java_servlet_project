<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.taskmanager.Task"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Edit Task</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body class="bg-light">

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary"> <!-- Updated background color to bg-primary -->
    <div class="container">
        <a class="navbar-brand" href="/TaskManagementSystem/Userdashboard?userId=<%=session.getAttribute("userId")%>">Task Manager</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="/TaskManagementSystem/Userdashboard?userId=<%=session.getAttribute("userId")%>">Userdashboard</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/TaskManagementSystem/Createtask.jsp">Add Task</a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<div class="container mt-5">
    <h2>Edit Task</h2>
    <%
    Task task = (Task) request.getAttribute("task");
    if (task == null) {
    %>
    <div class="alert alert-info mt-3">Task could not be found to edit.</div>
    <%
    } else {
    %>
    <form action="editTask" method="post">
        <input type="hidden" id="taskId" name="taskId" value="<%=task.getId()%>">
        <input type="hidden" id="userId" name="userId" value="<%=session.getAttribute("userId")%>">
        <div class="form-group">
            <label for="taskTitle">Task Title</label>
            <input type="text" class="form-control" id="taskTitle" name="taskTitle" value="<%=task.getTaskTitle()%>">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea class="form-control" id="description" name="description" rows="3"><%=task.getDescription()%></textarea>
        </div>
        <div class="form-group">
            <label for="dueDate">Due Date</label>
            <input type="date" class="form-control" id="dueDate" name="dueDate" value="<%=task.getDueDate()%>">
        </div>
        <div class="form-group">
            <label for="priority">Priority</label>
            <select class="form-control" id="priority" name="priority">
                <option value="Low" <%=task.getPriority().equals("Low") ? "selected" : ""%>>Low</option>
                <option value="Medium" <%=task.getPriority().equals("Medium") ? "selected" : ""%>>Medium</option>
                <option value="High" <%=task.getPriority().equals("High") ? "selected" : ""%>>High</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Update Task</button>
    </form>
    <%
    }
    %>
</div>


	<!-- Bootstrap JS and Popper.js (if needed) -->
	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>