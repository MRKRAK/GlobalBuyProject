package com.globalbuy.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.globalbuy.util.GlobalBuyConnection;

public class RegisterUI {

    public boolean registerUser(String nombre, String apellido, String correo, String contrasena, String direccion, String codigoPostal, String telefono) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Obtener la conexión de la base de datos
            conn = GlobalBuyConnection.getConnection();

            // Preparar la consulta SQL para insertar un nuevo usuario
            String sql = "INSERT INTO Usuarios (nombre, apellido, correo, contrasena, direccion, codigo_postal, telefono) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, correo);
            pstmt.setString(4, contrasena);
            pstmt.setString(5, direccion);
            pstmt.setString(6, codigoPostal);
            pstmt.setString(7, telefono);

            // Ejecutar la consulta de inserción
            int rowsAffected = pstmt.executeUpdate();

            // Verificar si la inserción fue exitosa
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
            return false;
        } finally {
            // Cerrar el PreparedStatement y la conexión
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
