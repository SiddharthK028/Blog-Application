<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        h1 {
            color: #333;
            text-align: center;
            margin-top: 20px;
        }

        p {
            margin: 10px 20px;
        }

        /* Style for the logged in user message */
        .user-info {
            font-style: italic;
            margin-bottom: 30px;
        }

        /* Styling the logout link */
        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Welcome to Admin Dashboard!</h1>
    <p>This is a secure area accessible only to users with the Admin role.</p>
    <!-- Example of displaying username from session -->
    <p class="user-info">Logged in as: ${sessionScope.username}</p>
    <p>Place your admin-specific content and functionalities here.</p>
    <p><a href="logoutServlet">Logout</a></p>
</body>
</html>
