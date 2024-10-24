package com.example.model;

public class Appointment {
    private String name;
    private String email;
    private String doctorName;
    private String appointmentDate; // Change variable name if needed
    private String appointmentTime; // Change variable name if needed

    public Appointment(String name, String email, String doctorName, String appointmentDate, String appointmentTime) {
        this.name = name;
        this.email = email;
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }
}
