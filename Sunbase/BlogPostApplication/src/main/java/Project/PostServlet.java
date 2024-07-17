package Project;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;

@WebServlet("/PostServlet")
@MultipartConfig
public class PostServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sunbase";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Siddharth@1234";
    private static final String UPLOAD_DIRECTORY = "uploads";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("role") == null || !"Admin".equals(session.getAttribute("role"))) {
            response.sendRedirect("login.html"); // Redirect if not logged in as Admin
            return;
        }

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String fileName = null;
        String filePath = null;

        // Handling file upload
        Part filePart = request.getPart("file");
        if (filePart != null) {
            fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            filePath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY + File.separator + fileName;
            File uploadDir = new File(getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            filePart.write(filePath);
        }

        // Save post to database
        try {
            savePostToDB(title, content, fileName);
            response.sendRedirect("admin.jsp"); // Redirect to Admin dashboard after post creation
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h3>Error creating post. Please try again later.</h3>");
        }
    }

    private void savePostToDB(String title, String content, String fileName) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "INSERT INTO posts (title, content, image_video) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, title);
                statement.setString(2, content);
                statement.setString(3, fileName);
                statement.executeUpdate();
            }
        }
    }
}

