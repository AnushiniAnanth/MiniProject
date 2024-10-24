package com.example.servlet;

import com.example.dao.AppointmentDAO;
import com.example.model.Appointment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/submit_appointment")
public class AppointmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String doctorName = request.getParameter("doctorname");
        String date = request.getParameter("date");
        String time = request.getParameter("time");

        Appointment appointment = new Appointment(name, email, doctorName, date, time);
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        try {
            boolean isSaved = appointmentDAO.saveAppointment(appointment);
            if (isSaved) {
                response.sendRedirect("success.jsp"); // Redirect to success page
            } else {
                response.sendRedirect("error.jsp");   // Redirect to error page
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirect to error page in case of exception
        }
    }
}
