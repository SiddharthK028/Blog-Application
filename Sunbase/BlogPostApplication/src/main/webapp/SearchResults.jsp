<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Results</title>
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
        }

        /* Container Styles */
        .container {
            width: 80%;
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }

        /* Header Styles */
        header {
            background-color: #333;
            color: #fff;
            padding: 10px 0;
        }

        header h1 {
            text-align: center;
        }

        /* Main Styles */
        main {
            margin-top: 20px;
        }

        /* Blog posts section styles */
        .blog-posts {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
            gap: 20px;
        }

        .blog-post {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .blog-post h2 {
            margin-top: 0;
            font-size: 24px;
        }

        .blog-post a {
            text-decoration: none;
            color: #007bff;
        }

        .blog-post a:hover {
            text-decoration: underline;
        }

        .post-meta {
            color: #666;
            font-size: 14px;
            margin-bottom: 10px;
        }

        .post-content {
            line-height: 1.6;
        }

        /* Footer Styles */
        footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px 0;
            margin-top: 20px;
        }

        footer p {
            margin: 0;
        }
    </style>
</head>
<body>
    <header>
        <div class="container">
            <h1>Search Results</h1>
        </div>
    </header>

    <main>
        <div class="container">
            <section class="blog-posts">
                <c:forEach items="${searchResults}" var="post">
                    <article class="blog-post">
                        <h2><a href="viewPost.jsp?id=${post.id}">${post.title}</a></h2>
                        <p class="post-meta">Posted on ${post.createdAt}</p>
                        <p class="post-content">${post.content}</p>
                    </article>
                </c:forEach>
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
