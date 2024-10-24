package com.example.servlet;

import com.example.dao.LoginDao;
import com.example.model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private LoginDao loginDao = new LoginDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = loginDao.validate(email, password);

        if (user != null) {
            // Redirect to success page
            response.sendRedirect("index.jsp");
        } else {
            // Redirect back to login with error message
            response.sendRedirect("error.jsp?error=1");
        }
    }
}
