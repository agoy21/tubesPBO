/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes.DAO;

/**
 *
 * @author Lenovo
 */
import tubes.Model.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    private Connection connection;

    public PatientDAO(Connection connection) {
        this.connection = connection;
    }

    public void addPatient(Patient patient) throws SQLException {
        String sql = "INSERT INTO Patients (patient_ID, nric, name, address, birthDate, usedGender, usedPhoneNumber, usedUserType) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, patient.getPatientID());
            stmt.setString(2, patient.getNric());
            stmt.setString(3, patient.getName());
            stmt.setString(4, patient.getAddress());
            stmt.setDate(5, patient.getBirthDate());
            stmt.setString(6, patient.getUsedGender());
            stmt.setString(7, patient.getUsedPhoneNumber());
            stmt.setString(8, patient.getUsedUserType());
            stmt.executeUpdate();
        }
    }

    public Patient getPatientById(String patientID) throws SQLException {
        String sql = "SELECT * FROM Patients WHERE patient_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, patientID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Patient(
                        rs.getString("patient_ID"),
                        rs.getString("nric"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getDate("birthDate"),
                        rs.getString("usedGender"),
                        rs.getString("usedPhoneNumber"),
                        rs.getString("usedUserType")
                    );
                }
            }
        }
        return null;
    }

    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM Patients";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Patient patient = new Patient(
                    rs.getString("patient_ID"),
                    rs.getString("nric"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getDate("birthDate"),
                    rs.getString("usedGender"),
                    rs.getString("usedPhoneNumber"),
                    rs.getString("usedUserType")
                );
                patients.add(patient);
            }
        }
        return patients;
    }

    public void updatePatient(Patient patient) throws SQLException {
        String sql = "UPDATE Patients SET nric = ?, name = ?, address = ?, birthDate = ?, usedGender = ?, usedPhoneNumber = ?, usedUserType = ? WHERE patient_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, patient.getNric());
            stmt.setString(2, patient.getName());
            stmt.setString(3, patient.getAddress());
            stmt.setDate(4, patient.getBirthDate());
            stmt.setString(5, patient.getUsedGender());
            stmt.setString(6, patient.getUsedPhoneNumber());
            stmt.setString(7, patient.getUsedUserType());
            stmt.setString(8, patient.getPatientID());
            stmt.executeUpdate();
        }
    }

    public void deletePatient(String patientID) throws SQLException {
        String sql = "DELETE FROM Patients WHERE patient_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, patientID);
            stmt.executeUpdate();
        }
    }
}
