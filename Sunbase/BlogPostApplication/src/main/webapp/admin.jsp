<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 20px;
        }
        h1 {
            color: #333;
        }
        p {
            font-size: 1.1em;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            margin-bottom: 10px;
        }
        a {
            text-decoration: none;
            color: #007bff;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Admin Dashboard</h1>
    <%-- Only show content if user has "Admin" role --%>
    <% if ("Admin".equals(session.getAttribute("role"))) { %>
        <p>Welcome, <%= session.getAttribute("username") %>. You have access to Admin features.</p>
        <ul>
            <li><a href="#">Manage Users</a></li>
            <li><a href="#">View Reports</a></li>
            <!-- Add more admin-specific links here -->
        </ul>
    <% } else { %>
        <p>Access Denied. You do not have permission to view this page.</p>
        <p><a href="welcome.jsp">Go back to Welcome Page</a></p>
    <% } %>
    
    <p><a href="logout.jsp">Logout</a></p>
</body>
</html>
