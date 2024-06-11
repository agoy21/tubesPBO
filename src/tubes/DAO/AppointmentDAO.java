/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes.DAO;

/**
 *
 * @author Lenovo
 */
import tubes.Model.Appointment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    private Connection connection;

    public AppointmentDAO(Connection connection) {
        this.connection = connection;
    }

    public void addAppointment(Appointment appointment) throws SQLException {
        String sql = "INSERT INTO Appointments (appointment_id, timeStart, timeEnd, doctor_id, patient_id, room_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, appointment.getAppointmentID());
            stmt.setTimestamp(2, appointment.getTimeStart());
            stmt.setTimestamp(3, appointment.getTimeEnd());
            stmt.setString(4, appointment.getDoctorID());
            stmt.setString(5, appointment.getPatientID());
            stmt.setString(6, appointment.getRoomID());
            stmt.executeUpdate();
        }
    }

    public Appointment getAppointmentById(String appointmentID) throws SQLException {
        String sql = "SELECT * FROM Appointments WHERE appointment_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, appointmentID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Appointment(
                        rs.getString("appointment_id"),
                        rs.getTimestamp("timeStart"),
                        rs.getTimestamp("timeEnd"),
                        rs.getString("doctor_id"),
                        rs.getString("patient_id"),
                        rs.getString("room_id")
                    );
                }
            }
        }
        return null;
    }

    public List<Appointment> getAllAppointments() throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM Appointments";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Appointment appointment = new Appointment(
                    rs.getString("appointment_id"),
                    rs.getTimestamp("timeStart"),
                    rs.getTimestamp("timeEnd"),
                    rs.getString("doctor_id"),
                    rs.getString("patient_id"),
                    rs.getString("room_id")
                );
                appointments.add(appointment);
            }
        }
        return appointments;
    }

    public void updateAppointment(Appointment appointment) throws SQLException {
        String sql = "UPDATE Appointments SET timeStart = ?, timeEnd = ?, doctor_id = ?, patient_id = ?, room_id = ? WHERE appointment_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setTimestamp(1, appointment.getTimeStart());
            stmt.setTimestamp(2, appointment.getTimeEnd());
            stmt.setString(3, appointment.getDoctorID());
            stmt.setString(4, appointment.getPatientID());
            stmt.setString(5, appointment.getRoomID());
            stmt.setString(6, appointment.getAppointmentID());
            stmt.executeUpdate();
        }
    }

    public void deleteAppointment(String appointmentID) throws SQLException {
        String sql = "DELETE FROM Appointments WHERE appointment_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, appointmentID);
            stmt.executeUpdate();
        }
    }
}