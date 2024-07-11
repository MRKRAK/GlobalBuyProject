package com.globalbuy.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.globalbuy.util.GlobalBuyConnection;

public class CatalogUI {

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Obtener la conexión de la base de datos
            conn = GlobalBuyConnection.getConnection();

            // Preparar la consulta SQL para obtener todos los productos
            String sql = "SELECT id_producto, nombre, descripcion, precio, stock, imagen_url FROM Productos";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            // Iterar sobre los resultados y agregar cada producto a la lista
            while (rs.next()) {
                int id = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                String imagenUrl = rs.getString("imagen_url");

                Product product = new Product(id, nombre, descripcion, precio, stock, imagenUrl);
                products.add(product);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener los productos: " + e.getMessage());
        } finally {
            // Cerrar ResultSet, PreparedStatement y la conexión
            try {
                if (rs != null) {
                    rs.close();
                }
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

        return products;
    }
}
