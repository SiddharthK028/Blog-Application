<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Blog Post</title>
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

        /* Form Styles */
        form {
            max-width: 600px;
            margin: 0 auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        input[type="text"], textarea, input[type="url"], input[type="file"], input[type="submit"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            box-sizing: border-box;
        }

        textarea {
            resize: vertical;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        img {
            max-width: 100%;
            height: auto;
            margin-bottom: 10px;
            border-radius: 4px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }
    </style>
</head>
<body>
    <h1>Update Blog Post</h1>
    <form action="updatePostServlet" method="post" enctype="multipart/form-data">
        Title: <input type="text" name="title" value="${post.title}" required><br><br>
        Content: <textarea name="content" rows="5" cols="40" required>${post.content}</textarea><br><br>
        Current Image: <img src="${post.imageUrl}" width="200"><br>
        New Image: <input type="file" name="image"><br><br>
        Video URL: <input type="url" name="videoUrl" value="${post.videoUrl}"><br><br>
        <input type="hidden" name="postId" value="${post.id}">
        <input type="submit" value="Update Post">
    </form>
</body>
</html>
