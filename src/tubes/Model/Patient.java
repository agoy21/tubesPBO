/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes.Model;

/**
 *
 * @author Lenovo
 */
public class Patient {
    private String patientID;
    private String nric;
    private String name;
    private String address;
    private java.sql.Date birthDate;
    private String usedGender;
    private String usedPhoneNumber;
    private String usedUserType;

    public Patient() {}

    public Patient(String patientID, String nric, String name, String address, java.sql.Date birthDate, String usedGender, String usedPhoneNumber, String usedUserType) {
        this.patientID = patientID;
        this.nric = nric;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
        this.usedGender = usedGender;
        this.usedPhoneNumber = usedPhoneNumber;
        this.usedUserType = usedUserType;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getNric() {
        return nric;
    }

    public void setNric(String nric) {
        this.nric = nric;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public java.sql.Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(java.sql.Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getUsedGender() {
        return usedGender;
    }

    public void setUsedGender(String usedGender) {
        this.usedGender = usedGender;
    }

    public String getUsedPhoneNumber() {
        return usedPhoneNumber;
    }

    public void setUsedPhoneNumber(String usedPhoneNumber) {
        this.usedPhoneNumber = usedPhoneNumber;
    }

    public String getUsedUserType() {
        return usedUserType;
    }

    public void setUsedUserType(String usedUserType) {
        this.usedUserType = usedUserType;
    }
}
