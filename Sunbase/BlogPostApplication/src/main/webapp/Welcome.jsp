<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <style>
        /* General Reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Body Styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            line-height: 1.6;
            padding: 20px;
        }

        /* Container Styles */
        .container {
            max-width: 600px;
            margin: 0 auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        p {
            margin-bottom: 15px;
        }

        a {
            text-decoration: none;
            color: #007bff;
        }

        a:hover {
            text-decoration: underline;
        }

        .admin-link {
            text-align: center;
            margin-top: 20px;
        }

        .admin-link a {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border-radius: 4px;
            display: inline-block;
        }

        .admin-link a:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome, <%= session.getAttribute("username") %>!</h1>
        
        <%-- Check if user is admin to show admin link --%>
        <% if ("Admin".equals(session.getAttribute("role"))) { %>
            <div class="admin-link">
                <a href="admin.jsp">Go to Admin Dashboard</a>
            </div>
        <% } else { %>
            <p>You do not have access to the Admin Dashboard.</p>
        <% } %>
        
        <p><a href="logout.jsp">Logout</a></p>
    </div>
</body>
</html>
