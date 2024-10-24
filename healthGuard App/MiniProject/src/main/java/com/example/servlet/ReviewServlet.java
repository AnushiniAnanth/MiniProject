package com.example.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Reading form data
        String name = request.getParameter("name");
        String rating = request.getParameter("rating");
        String review = request.getParameter("review");

        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/reviewsdb"; // Replace with your DB URL
        String dbUser = "root"; // Replace with your DB user
        String dbPassword = "password"; // Replace with your DB password

        // SQL insert query
        String sql = "INSERT INTO reviews (name, rating, review) VALUES (?, ?, ?)";

        try {
            // Load JDBC driver (optional for newer versions of JDBC)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish database connection
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            // Create a PreparedStatement
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, Integer.parseInt(rating));
            statement.setString(3, review);

            // Execute the query
            int rowsInserted = statement.executeUpdate();

            // Generate a response
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            if (rowsInserted > 0) {
                out.println("<h2>Thank you for your review!</h2>");
                out.println("<p><strong>Name:</strong> " + name + "</p>");
                out.println("<p><strong>Rating:</strong> " + rating + "</p>");
                out.println("<p><strong>Review:</strong> " + review + "</p>");
            } else {
                out.println("<h2>Error: Unable to submit your review.</h2>");
            }
            out.println("</body></html>");

            // Close resources
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

