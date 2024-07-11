package com.globalbuy.manager;

import com.globalbuy.util.GlobalBuyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusquedaManager {

    public List<String> buscarProductosPorNombre(String nombre) {
        List<String> productos = new ArrayList<>();
        String query = "SELECT nombre FROM Productos WHERE nombre LIKE ?";

        try (Connection conn = GlobalBuyConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, "%" + nombre + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                productos.add(rs.getString("nombre"));
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar productos por nombre: " + e.getMessage());
        }
        return productos;
    }

    public List<String> filtrarProductosPorCategoria(int categoriaID) {
        List<String> productos = new ArrayList<>();
        String query = "SELECT nombre FROM Productos WHERE categoriaID = ?";

        try (Connection conn = GlobalBuyConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, categoriaID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                productos.add(rs.getString("nombre"));
            }

        } catch (SQLException e) {
            System.err.println("Error al filtrar productos por categoría: " + e.getMessage());
        }
        return productos;
    }

    public List<String> filtrarProductosPorPrecio(double precioMin, double precioMax) {
        List<String> productos = new ArrayList<>();
        String query = "SELECT nombre FROM Productos WHERE precio BETWEEN ? AND ?";

        try (Connection conn = GlobalBuyConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDouble(1, precioMin);
            stmt.setDouble(2, precioMax);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                productos.add(rs.getString("nombre"));
            }

        } catch (SQLException e) {
            System.err.println("Error al filtrar productos por precio: " + e.getMessage());
        }
        return productos;
    }
}
