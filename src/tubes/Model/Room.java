/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes.Model;

/**
 *
 * @author Lenovo
 */
public class Room {
    private String roomID;
    private int floor;
    private int number;

    public Room() {}

    public Room(String roomID, int floor, int number) {
        this.roomID = roomID;
        this.floor = floor;
        this.number = number;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
