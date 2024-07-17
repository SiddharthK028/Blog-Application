<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blog Posts</title>
    <style>
        /* Reset basic styles */
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        /* Global styles */
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            background-color: #f4f4f4;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
        }

        header {
            background-color: #333;
            color: #fff;
            padding: 10px 0;
            text-align: center;
        }

        header h1 {
            font-size: 2rem;
        }

        main {
            padding: 20px 0;
        }

        .blog-posts {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
            gap: 20px;
        }

        .blog-post {
            background-color: #fff;
            padding: 15px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }

        .blog-post h2 {
            font-size: 1.5rem;
            margin-bottom: 10px;
        }

        .blog-post .post-meta {
            color: #666;
            font-size: 0.9rem;
            margin-bottom: 10px;
        }

        .blog-post .post-content {
            color: #333;
            margin-bottom: 15px;
        }

        .blog-post .post-media img {
            max-width: 100%;
            height: auto;
            border-radius: 5px;
            margin-bottom: 10px;
        }

        /* Optional: Styles for video */
        /*
        .blog-post .post-media video {
            max-width: 100%;
            height: auto;
            border-radius: 5px;
            margin-bottom: 10px;
        }
        */

        footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px 0;
        }

        footer p {
            font-size: 0.8rem;
        }
    </style>
</head>
<body>
    <header>
        <div class="container">
            <h1>Blog Posts</h1>
        </div>
    </header>

    <main>
        <div class="container">
            <section class="blog-posts">
                <!-- Example blog post item -->
                <article class="blog-post">
                    <h2><a href="viewPost.html">Blog Post Title</a></h2>
                    <p class="post-meta">Posted on January 1, 2024 by Admin</p>
                    <p class="post-content">Summary of blog post content...</p>
                    <div class="post-media">
                        <img src="path/to/image.jpg" alt="Blog Post Image">
                        <!-- Optional: Video -->
                        <!-- <video controls>
                            <source src="path/to/video.mp4" type="video/mp4">
                            Your browser does not support the video tag.
                        </video> -->
                    </div>
                </article>
                <!-- Repeat for other blog posts -->
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
