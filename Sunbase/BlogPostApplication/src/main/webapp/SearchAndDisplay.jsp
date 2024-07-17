<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blog Posts</title>
    <link rel="stylesheet" href="styles.css"> <!-- Link to your CSS stylesheet -->
</head>
<body>
    <header>
        <div class="container">
            <h1>Blog Posts</h1>
        </div>
    </header>

    <main>
        <div class="container">
            <form action="searchServlet" method="get">
                <input type="text" name="query" placeholder="Search by title or date">
                <button type="submit">Search</button>
            </form>

            <section class="blog-posts">
                <!-- Blog posts will be displayed dynamically -->
                <%-- Include JSP code to display search results here --%>
            </section>
        </div>
    </main>

    <footer>
        <div class="container">
            <p>&copy; 2024 BlogName. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>
