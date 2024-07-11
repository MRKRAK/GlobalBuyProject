package com.globalbuy.manager;

import com.globalbuy.model.Producto;
import com.globalbuy.util.GlobalBuyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoManager {

    // Método para agregar un nuevo producto
    public boolean agregarProducto(Producto producto) {
        String query = "INSERT INTO Productos (nombre, descripcion, precio, categoriaID, stock, imagen_url) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = GlobalBuyConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, producto.getNombre());
            pstmt.setString(2, producto.getDescripcion());
            pstmt.setDouble(3, producto.getPrecio());
            pstmt.setInt(4, producto.getCategoriaID());
            pstmt.setInt(5, producto.getStock());
            pstmt.setString(6, producto.getImagenUrl());
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        producto.setIdProducto(generatedKeys.getInt(1));
                    }
                }
            }
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar el producto: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener todos los productos
    public List<Producto> obtenerTodosLosProductos() {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM Productos";
        try (Connection conn = GlobalBuyConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCategoriaID(rs.getInt("categoriaID"));
                producto.setStock(rs.getInt("stock"));
                producto.setImagenUrl(rs.getString("imagen_url"));
                
                productos.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los productos: " + e.getMessage());
        }
        return productos;
    }

    // Método para actualizar un producto existente
    public boolean actualizarProducto(Producto producto) {
        String query = "UPDATE Productos SET nombre = ?, descripcion = ?, precio = ?, categoriaID = ?, stock = ?, imagen_url = ? WHERE id_producto = ?";
        try (Connection conn = GlobalBuyConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, producto.getNombre());
            pstmt.setString(2, producto.getDescripcion());
            pstmt.setDouble(3, producto.getPrecio());
            pstmt.setInt(4, producto.getCategoriaID());
            pstmt.setInt(5, producto.getStock());
            pstmt.setString(6, producto.getImagenUrl());
            pstmt.setInt(7, producto.getIdProducto());
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un producto por su ID
    public boolean eliminarProducto(int idProducto) {
        String query = "DELETE FROM Productos WHERE id_producto = ?";
        try (Connection conn = GlobalBuyConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, idProducto);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
            return false;
        }
    }
}
