/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes.DAO;

/**
 *
 * @author Lenovo
 */
import tubes.Model.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    private Connection connection;

    public RoomDAO(Connection connection) {
        this.connection = connection;
    }

    public void addRoom(Room room) throws SQLException {
        String sql = "INSERT INTO Room (room_id, floor, number) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, room.getRoomID());
            stmt.setInt(2, room.getFloor());
            stmt.setInt(3, room.getNumber());
            stmt.executeUpdate();
        }
    }

    public Room getRoomById(String roomID) throws SQLException {
        String sql = "SELECT * FROM Room WHERE room_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, roomID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Room(
                        rs.getString("room_id"),
                        rs.getInt("floor"),
                        rs.getInt("number")
                    );
                }
            }
        }
        return null;
    }

    public List<Room> getAllRooms() throws SQLException {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM Room";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Room room = new Room(
                    rs.getString("room_id"),
                    rs.getInt("floor"),
                    rs.getInt("number")
                );
                rooms.add(room);
            }
        }
        return rooms;
    }

    public void updateRoom(Room room) throws SQLException {
        String sql = "UPDATE Room SET floor = ?, number = ? WHERE room_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, room.getFloor());
            stmt.setInt(2, room.getNumber());
            stmt.setString(3, room.getRoomID());
            stmt.executeUpdate();
        }
    }

    public void deleteRoom(String roomID) throws SQLException {
        String sql = "DELETE FROM Room WHERE room_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, roomID);
            stmt.executeUpdate();
        }
    }
}