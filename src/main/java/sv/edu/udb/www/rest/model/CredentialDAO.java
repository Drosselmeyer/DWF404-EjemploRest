/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.udb.www.rest.model;

/**
 *
 * @author Drosselmeyer
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sv.edu.udb.www.rest.resources.DatabaseConnection;

public class CredentialDAO {
    public Credential getCredentialByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM credentials WHERE username = ?";
        Credential credential = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    credential = new Credential();
                    credential.setId(rs.getInt("id"));
                    credential.setUsername(rs.getString("username"));
                    credential.setPassword(rs.getString("password"));
                }
            }
        }
        return credential;
    }
}
