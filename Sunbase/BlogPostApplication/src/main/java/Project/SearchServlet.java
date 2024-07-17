package Project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/sunbase";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "Siddharth@1234";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = request.getParameter("query");

        // Perform search query in database
        List<BlogPost> searchResults = searchBlogPosts(query);

        // Set search results as request attribute
        request.setAttribute("searchResults", searchResults);

        // Forward request to the JSP for rendering
        request.getRequestDispatcher("searchResults.jsp").forward(request, response);
    }

    private List<BlogPost> searchBlogPosts(String query) {
        List<BlogPost> results = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            String sql = "SELECT id, title, content, created_at FROM blog_posts WHERE title LIKE ? OR created_at LIKE ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + query + "%");
            stmt.setString(2, "%" + query + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String createdAt = rs.getString("created_at");
                BlogPost post = new BlogPost();
                results.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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
        return results;
    }
}
