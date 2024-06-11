/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes.Service;

/**
 *
 * @author Lenovo
 */
import tubes.DAO.MedicalCheckUpDAO;
import tubes.Model.MedicalCheckUp;
import java.sql.SQLException;
import java.util.List;

public class MedicalCheckUpService {
    private MedicalCheckUpDAO medicalCheckUpDAO;

    public MedicalCheckUpService(MedicalCheckUpDAO medicalCheckUpDAO) {
        this.medicalCheckUpDAO = medicalCheckUpDAO;
    }

    public void scheduleMedicalCheckUp(MedicalCheckUp medicalCheckUp) throws SQLException {
        medicalCheckUpDAO.addMedicalCheckUp(medicalCheckUp);
    }

    public MedicalCheckUp getMedicalCheckUpById(String medicalCheckUpID) throws SQLException {
        return medicalCheckUpDAO.getMedicalCheckUpById(medicalCheckUpID);
    }

    public List<MedicalCheckUp> getAllMedicalCheckUps() throws SQLException {
        return medicalCheckUpDAO.getAllMedicalCheckUps();
    }

    public void updateMedicalCheckUp(MedicalCheckUp medicalCheckUp) throws SQLException {
        medicalCheckUpDAO.updateMedicalCheckUp(medicalCheckUp);
    }

    public void deleteMedicalCheckUp(String medicalCheckUpID) throws SQLException {
        medicalCheckUpDAO.deleteMedicalCheckUp(medicalCheckUpID);
    }

    
}
