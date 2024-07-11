package com.globalbuy.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.globalbuy.util.GlobalBuyConnection;

public class ProductManagementUI {

    public boolean addProduct(String nombre, String descripcion, double precio, int categoriaID, int stock, String imagenUrl) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean isAdded = false;

        try {
            // Obtener la conexión a la base de datos
            conn = GlobalBuyConnection.getConnection();

            // Preparar la consulta SQL para insertar un nuevo producto
            String sql = "INSERT INTO Productos (nombre, descripcion, precio, categoriaID, stock, imagen_url) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombre);
            pstmt.setString(2, descripcion);
            pstmt.setDouble(3, precio);
            pstmt.setInt(4, categoriaID);
            pstmt.setInt(5, stock);
            pstmt.setString(6, imagenUrl);

            // Ejecutar la inserción
            int rowsAffected = pstmt.executeUpdate();
            isAdded = (rowsAffected > 0);

        } catch (SQLException e) {
            System.out.println("Error al agregar el producto: " + e.getMessage());
        } finally {
            // Cerrar PreparedStatement y la conexión
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

        return isAdded;
    }
}
