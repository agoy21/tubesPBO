/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes.Model;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class MedicalCheckUp {
      private String medicalCheckUpID;
    private Date date;
    private String result;
    private String typeOfCheckUp;
    private String doctorID;
    private String patientID;

    public MedicalCheckUp() {}

    public MedicalCheckUp(String medicalCheckUpID, Date date, String result, String typeOfCheckUp, String doctorID, String patientID) {
        this.medicalCheckUpID = medicalCheckUpID;
        this.date = date;
        this.result = result;
        this.typeOfCheckUp = typeOfCheckUp;
        this.doctorID = doctorID;
        this.patientID = patientID;
    }

    public String getMedicalCheckUpID() {
        return medicalCheckUpID;
    }

    public void setMedicalCheckUpID(String medicalCheckUpID) {
        this.medicalCheckUpID = medicalCheckUpID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTypeOfCheckUp() {
        return typeOfCheckUp;
    }

    public void setTypeOfCheckUp(String typeOfCheckUp) {
        this.typeOfCheckUp = typeOfCheckUp;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
}
