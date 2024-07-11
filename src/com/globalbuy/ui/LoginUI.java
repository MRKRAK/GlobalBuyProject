package com.globalbuy.ui;

import com.globalbuy.util.GlobalBuyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUI {
    public boolean login(String correo, String contrasena) {
        String query = "SELECT * FROM Usuarios WHERE correo = ? AND contrasena = ?";
        try (Connection conexion = GlobalBuyConnection.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, correo);
            pstmt.setString(2, contrasena);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Si hay resultados, el usuario es válido
        } catch (SQLException ex) {
            System.err.println("Error al validar usuario: " + ex.getMessage());
            return false;
        }
    }
    
    // Puedes añadir más métodos para la interfaz de usuario y la lógica de negocio aquí
}
