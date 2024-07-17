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

@WebServlet("/createPostServlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10) // 10 MB max file size
public class CreatePostServlet extends HttpServlet {
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

        // Image handling
        Part filePart = request.getPart("image");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = filePart.getInputStream();

        // Save image to database and get its ID
        int imageId = saveImageToDatabase(fileName, fileContent);

        // Save blog post to database
        saveBlogPostToDatabase(title, content, imageId, videoUrl);

        // Redirect to admin dashboard or another page
        response.sendRedirect("adminDashboard.jsp");
    }

    // Method to save uploaded image to database and return its ID
    private int saveImageToDatabase(String fileName, InputStream fileContent) throws IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int imageId = -1;
        try {
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            String sql = "INSERT INTO media_files (filename, content_type, data) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, fileName);
            stmt.setString(2, Files.probeContentType(Paths.get(fileName)));
            stmt.setBlob(3, fileContent);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                imageId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
            throw new IOException("Database error occurred", e);
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
        return imageId;
    }

    // Method to save blog post metadata to database
    private void saveBlogPostToDatabase(String title, String content, int imageId, String videoUrl) throws IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            String sql = "INSERT INTO blog_posts (title, content, image_id, video_url) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setString(2, content);
            stmt.setInt(3, imageId);
            stmt.setString(4, videoUrl);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
            throw new IOException("Database error occurred", e);
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
