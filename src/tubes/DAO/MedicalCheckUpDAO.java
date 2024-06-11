/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes.DAO;

/**
 *
 * @author Lenovo
 */
import tubes.Model.MedicalCheckUp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicalCheckUpDAO {
    private Connection connection;

    public MedicalCheckUpDAO(Connection connection) {
        this.connection = connection;
    }

    public void addMedicalCheckUp(MedicalCheckUp medicalCheckUp) throws SQLException {
        String sql = "INSERT INTO MedicalCheckUp (medicalCheckUp_id, date, result, typeOfCheckUp, doctor_id, patient_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, medicalCheckUp.getMedicalCheckUpID());
            stmt.setDate(2, (Date) medicalCheckUp.getDate());
            stmt.setString(3, medicalCheckUp.getResult());
            stmt.setString(4, medicalCheckUp.getTypeOfCheckUp());
            stmt.setString(5, medicalCheckUp.getDoctorID());
            stmt.setString(6, medicalCheckUp.getPatientID());
            stmt.executeUpdate();
        }
    }

    public MedicalCheckUp getMedicalCheckUpById(String medicalCheckUpID) throws SQLException {
        String sql = "SELECT * FROM MedicalCheckUp WHERE medicalCheckUp_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, medicalCheckUpID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new MedicalCheckUp(
                        rs.getString("medicalCheckUp_id"),
                        rs.getDate("date"),
                        rs.getString("result"),
                        rs.getString("typeOfCheckUp"),
                        rs.getString("doctor_id"),
                        rs.getString("patient_id")
                    );
                }
            }
        }
        return null;
    }

    public List<MedicalCheckUp> getAllMedicalCheckUps() throws SQLException {
        List<MedicalCheckUp> medicalCheckUps = new ArrayList<>();
        String sql = "SELECT * FROM MedicalCheckUp";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                MedicalCheckUp medicalCheckUp = new MedicalCheckUp(
                    rs.getString("medicalCheckUp_id"),
                    rs.getDate("date"),
                    rs.getString("result"),
                    rs.getString("typeOfCheckUp"),
                    rs.getString("doctor_id"),
                    rs.getString("patient_id")
                );
                medicalCheckUps.add(medicalCheckUp);
            }
        }
        return medicalCheckUps;
    }

    public void updateMedicalCheckUp(MedicalCheckUp medicalCheckUp) throws SQLException {
        String sql = "UPDATE MedicalCheckUp SET date = ?, result = ?, typeOfCheckUp = ?, doctor_id = ?, patient_id = ? WHERE medicalCheckUp_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, (Date) medicalCheckUp.getDate());
            stmt.setString(2, medicalCheckUp.getResult());
            stmt.setString(3, medicalCheckUp.getTypeOfCheckUp());
            stmt.setString(4, medicalCheckUp.getDoctorID());
            stmt.setString(5, medicalCheckUp.getPatientID());
            stmt.setString(6, medicalCheckUp.getMedicalCheckUpID());
            stmt.executeUpdate();
        }
    }

    public void deleteMedicalCheckUp(String medicalCheckUpID) throws SQLException {
        String sql = "DELETE FROM MedicalCheckUp WHERE medicalCheckUp_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, medicalCheckUpID);
            stmt.executeUpdate();
        }
    }
}