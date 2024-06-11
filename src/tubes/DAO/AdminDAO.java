/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes.DAO;

/**
 *
 * @author Lenovo
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tubes.Model.Admin;

public class AdminDAO {
    private Connection connection;

    public AdminDAO(Connection connection) {
        this.connection = connection;
    }

    public void addAdmin(Admin admin) throws SQLException {
        String sql = "INSERT INTO Admin (admin_ID, name, phoneNumber, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, admin.getAdminID());
            stmt.setString(2, admin.getName());
            stmt.setString(3, admin.getPhoneNumber());
            stmt.setString(4, admin.getEmail());
            stmt.executeUpdate();
        }
    }

    public Admin getAdminById(String adminID) throws SQLException {
        String sql = "SELECT * FROM Admin WHERE admin_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, adminID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Admin(
                        rs.getString("admin_ID"),
                        rs.getString("name"),
                        rs.getString("phoneNumber"),
                        rs.getString("email")
                    );
                }
            }
        }
        return null;
    }

    public List<Admin> getAllAdmins() throws SQLException {
        List<Admin> admins = new ArrayList<>();
        String sql = "SELECT * FROM Admin";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Admin admin = new Admin(
                    rs.getString("admin_ID"),
                    rs.getString("name"),
                    rs.getString("phoneNumber"),
                    rs.getString("email")
                );
                admins.add(admin);
            }
        }
        return admins;
    }

    public void updateAdmin(Admin admin) throws SQLException {
        String sql = "UPDATE Admin SET name = ?, phoneNumber = ?, email = ? WHERE admin_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, admin.getName());
            stmt.setString(2, admin.getPhoneNumber());
            stmt.setString(3, admin.getEmail());
            stmt.setString(4, admin.getAdminID());
            stmt.executeUpdate();
        }
    }

    public void deleteAdmin(String adminID) throws SQLException {
        String sql = "DELETE FROM Admin WHERE admin_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, adminID);
            stmt.executeUpdate();
        }
    }
}
