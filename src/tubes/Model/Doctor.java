/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes.Model;

/**
 *
 * @author Lenovo
 */
public class Doctor {
    private String doctorID;
    private String name;
    private String specialization;
    private String address;
    private java.sql.Date birthDate;

    public Doctor() {}

    public Doctor(String doctorID, String name, String specialization, String address, java.sql.Date birthDate) {
        this.doctorID = doctorID;
        this.name = name;
        this.specialization = specialization;
        this.address = address;
        this.birthDate = birthDate;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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
}
