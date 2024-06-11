/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes.Service;

/**
 *
 * @author Lenovo
 */
import tubes.DAO.AppointmentDAO;
import tubes.Model.Appointment;
import java.sql.SQLException;
import java.util.List;

public class AppointmentService {
    private AppointmentDAO appointmentDAO;

    public AppointmentService(AppointmentDAO appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }

    public void scheduleAppointment(Appointment appointment) throws SQLException {
        appointmentDAO.addAppointment(appointment);
    }

    public Appointment getAppointmentById(String appointmentID) throws SQLException {
        return appointmentDAO.getAppointmentById(appointmentID);
    }

    public List<Appointment> getAllAppointments() throws SQLException {
        return appointmentDAO.getAllAppointments();
    }

    public void updateAppointment(Appointment appointment) throws SQLException {
        appointmentDAO.updateAppointment(appointment);
    }

    public void cancelAppointment(String appointmentID) throws SQLException {
        appointmentDAO.deleteAppointment(appointmentID);
    }
}
