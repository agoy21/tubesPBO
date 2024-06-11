/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes.Model;

import java.sql.Timestamp;

/**
 *
 * @author Lenovo
 */
public class Appointment {
    private String appointmentID;
    private Timestamp timeStart;
    private Timestamp timeEnd;
    private String doctorID;
    private String patientID;
    private String roomID;

    public Appointment() {}

    public Appointment(String appointmentID, Timestamp timeStart, Timestamp timeEnd, String doctorID, String patientID, String roomID) {
        this.appointmentID = appointmentID;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.doctorID = doctorID;
        this.patientID = patientID;
        this.roomID = roomID;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public Timestamp getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Timestamp timeStart) {
        this.timeStart = timeStart;
    }

    public Timestamp getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Timestamp timeEnd) {
        this.timeEnd = timeEnd;
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

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }
}
