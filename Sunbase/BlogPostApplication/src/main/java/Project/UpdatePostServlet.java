package Project;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/updatePostServlet")
@MultipartConfig
public class UpdatePostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/sunbase";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "Siddharth@1234";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String videoUrl = request.getParameter("videoUrl");
        int postId = Integer.parseInt(request.getParameter("postId"));

        // Image handling
        String imageUrl = null;
        Part filePart = request.getPart("image");
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            try (InputStream fileContent = filePart.getInputStream()) {
                Files.copy(fileContent, Paths.get("upload-dir", fileName), StandardCopyOption.REPLACE_EXISTING);
                imageUrl = "upload-dir/" + fileName; // Save the path to the image in the database
            } catch (IOException e) {
                e.printStackTrace();
                // Handle file upload error
            }
        }

        // Update post in database
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            String sql = "UPDATE blog_posts SET title = ?, content = ?, image_url = ?, video_url = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setString(2, content);
            stmt.setString(3, imageUrl);
            stmt.setString(4, videoUrl);
            stmt.setInt(5, postId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                response.sendRedirect("adminDashboard.jsp"); // Redirect after successful update
            } else {
                // Handle failure to update
                response.sendRedirect("updatePost.jsp?id=" + postId); // Redirect back to update page with error message
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
            response.sendRedirect("error.html"); // Redirect to error page
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

