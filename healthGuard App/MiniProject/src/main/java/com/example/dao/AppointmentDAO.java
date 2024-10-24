package com.example.dao;

import com.example.model.Appointment;
import com.example.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppointmentDAO {
    public boolean saveAppointment(Appointment appointment) {
        boolean rowInserted = false;
        String sql = "INSERT INTO appointments (name, email, doctorname, appointmentdate, appointmenttime) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, appointment.getName());
            statement.setString(2, appointment.getEmail());
            statement.setString(3, appointment.getDoctorName());
            statement.setString(4, appointment.getAppointmentDate());
            statement.setString(5, appointment.getAppointmentTime());

            rowInserted = statement.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rowInserted;
    }
}
