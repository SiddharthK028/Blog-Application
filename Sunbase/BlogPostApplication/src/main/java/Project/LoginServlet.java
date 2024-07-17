package Project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/sunbase";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "Siddharth@1234";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Fetch hashed password from database based on username/email
        String hashedPasswordFromDB = ""; // Fetch this from your database query

        // Check if the entered password matches the hashed password from DB
        if (BCrypt.checkpw(password, hashedPasswordFromDB)) {
            // Authentication successful
            HttpSession session = request.getSession();
            session.setAttribute("username", username); // Store username in session
            session.setAttribute("role", "Admin"); // Assuming role retrieval logic

            // Redirect to dashboard based on role
            if ("Admin".equals(rs.getString("role"))) {
                response.sendRedirect("adminDashboard.jsp");
            } else {
                response.sendRedirect("userDashboard.jsp");
            }
        } else {
            // Authentication failed
            response.sendRedirect("login.jsp?error=auth");
        }
    }
}
