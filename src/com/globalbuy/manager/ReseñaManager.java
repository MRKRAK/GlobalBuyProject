package com.globalbuy.manager;

import com.globalbuy.model.Reseña;
import com.globalbuy.util.GlobalBuyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReseñaManager {

    private Connection connection;

    public ReseñaManager() {
        this.connection = GlobalBuyConnection.getConnection();
    }

    public boolean agregarReseña(Reseña reseña) {
        String query = "INSERT INTO Reseñas (id_producto, id_usuario, calificación, comentario, fecha_resena) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, reseña.getIdProducto());
            stmt.setInt(2, reseña.getIdUsuario());
            stmt.setInt(3, reseña.getCalificación());
            stmt.setString(4, reseña.getComentario());
            stmt.setDate(5, new java.sql.Date(reseña.getFechaReseña().getTime()));

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Reseña> obtenerReseñasPorProducto(int idProducto) {
        List<Reseña> reseñas = new ArrayList<>();
        String query = "SELECT * FROM Reseñas WHERE id_producto = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idProducto);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Reseña reseña = new Reseña();
                reseña.setIdReseña(rs.getInt("id_resena"));
                reseña.setIdProducto(rs.getInt("id_producto"));
                reseña.setIdUsuario(rs.getInt("id_usuario"));
                reseña.setCalificación(rs.getInt("calificación"));
                reseña.setComentario(rs.getString("comentario"));
                reseña.setFechaReseña(rs.getDate("fecha_resena"));

                reseñas.add(reseña);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reseñas;
    }

    public boolean actualizarReseña(Reseña reseña) {
        String query = "UPDATE Reseñas SET calificación = ?, comentario = ?, fecha_resena = ? WHERE id_resena = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, reseña.getCalificación());
            stmt.setString(2, reseña.getComentario());
            stmt.setDate(3, new java.sql.Date(reseña.getFechaReseña().getTime()));
            stmt.setInt(4, reseña.getIdReseña());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarReseña(int idReseña) {
        String query = "DELETE FROM Reseñas WHERE id_resena = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idReseña);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
