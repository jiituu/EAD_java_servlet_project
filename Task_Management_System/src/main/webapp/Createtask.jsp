<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
        content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Add Task</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <style>
        body {
            background-color: #f4f4f4; 
        }

        .form-group {
            margin-bottom: 2rem; 
        }

        .btn-primary {
            background-color: #28a745; 
            border-color: #28a745; 
        }

        .btn-primary:hover {
            background-color: #218838; 
            border-color: #1e7e34; 
        }
    </style>
</head>
<body class="bg-light">

    <!-- ... (your existing code) ... -->

    <div class="container mt-5" style="max-width: 650px">
        <h2>Add Task</h2>

        <form action="task" method="post">
            <!-- ... (your existing form code) ... -->
            <div class="form-group">
                <label for="priority">Priority:</label>
                <select class="form-control" id="priority" name="priority" required>
                    <option value="Low" disabled selected>Select Priority</option>
                    <option value="High">High</option>
                    <option value="Medium">Medium</option>
                    <option value="Low">Low</option>
                </select>
            </div>
            <input type="hidden" name="username" value="<%=session.getAttribute("userName")%>">
            <input type="hidden" name="userId" value="<%=session.getAttribute("userId")%>">
            <button type="submit" class="btn btn-primary">Add Task</button>
        </form>
    </div>

    <!-- Bootstrap JS and Popper.js (if needed) -->
    <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>
