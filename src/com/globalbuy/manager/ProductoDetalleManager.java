package com.globalbuy.manager;

import com.globalbuy.model.Producto;
import com.globalbuy.util.GlobalBuyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDetalleManager {

    // Método para obtener el detalle de un producto por su ID
    public Producto obtenerProductoPorId(int idProducto) {
        Producto producto = null;
        String query = "SELECT * FROM Productos WHERE id_producto = ?";
        try (Connection conn = GlobalBuyConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, idProducto);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    producto = new Producto();
                    producto.setIdProducto(rs.getInt("id_producto"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setPrecio(rs.getDouble("precio"));
                    producto.setCategoriaID(rs.getInt("categoriaID"));
                    producto.setStock(rs.getInt("stock"));
                    producto.setImagenUrl(rs.getString("imagen_url"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el producto por ID: " + e.getMessage());
        }
        return producto;
    }
}
