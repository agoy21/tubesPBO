/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes.DAO;

/**
 *
 * @author Lenovo
 */
import tubes.Model.Doctor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    private Connection connection;

    public DoctorDAO(Connection connection) {
        this.connection = connection;
    }

    public void addDoctor(Doctor doctor) throws SQLException {
        String sql = "INSERT INTO Doctors (doctor_id, name, specialization, address, birthDate) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, doctor.getDoctorID());
            stmt.setString(2, doctor.getName());
            stmt.setString(3, doctor.getSpecialization());
            stmt.setString(4, doctor.getAddress());
            stmt.setDate(5, doctor.getBirthDate());
            stmt.executeUpdate();
        }
    }

    public Doctor getDoctorById(String doctorID) throws SQLException {
        String sql = "SELECT * FROM Doctors WHERE doctor_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, doctorID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Doctor(
                        rs.getString("doctor_id"),
                        rs.getString("name"),
                        rs.getString("specialization"),
                        rs.getString("address"),
                        rs.getDate("birthDate")
                    );
                }
            }
        }
        return null;
    }

    public List<Doctor> getAllDoctors() throws SQLException {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM Doctors";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Doctor doctor = new Doctor(
                    rs.getString("doctor_id"),
                    rs.getString("name"),
                    rs.getString("specialization"),
                    rs.getString("address"),
                    rs.getDate("birthDate")
                );
                doctors.add(doctor);
            }
        }
        return doctors;
    }

    public void updateDoctor(Doctor doctor) throws SQLException {
        String sql = "UPDATE Doctors SET name = ?, specialization = ?, address = ?, birthDate = ? WHERE doctor_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, doctor.getName());
            stmt.setString(2, doctor.getSpecialization());
            stmt.setString(3, doctor.getAddress());
            stmt.setDate(4, doctor.getBirthDate());
            stmt.setString(5, doctor.getDoctorID());
            stmt.executeUpdate();
        }
    }

    public void deleteDoctor(String doctorID) throws SQLException {
        String sql = "DELETE FROM Doctors WHERE doctor_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, doctorID);
            stmt.executeUpdate();
        }
    }
}
