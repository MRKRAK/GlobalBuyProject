package com.globalbuy.manager;

import com.globalbuy.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import com.globalbuy.util.GlobalBuyConnection;

public class UsuarioManager {
    private Connection connection;

    public UsuarioManager() {
        connection = GlobalBuyConnection.getConnection();
    }

    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, apellido = ?, correo = ?, contrasena = ?, direccion = ?, codigo_postal = ?, telefono = ?, fecha_registro = ? WHERE id_usuario = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getContrasena());
            ps.setString(5, usuario.getDireccion());
            ps.setString(6, usuario.getCodigoPostal());
            ps.setString(7, usuario.getTelefono());
            ps.setDate(8, new java.sql.Date(usuario.getFechaRegistro().getTime()));
            ps.setInt(9, usuario.getIdUsuario());
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Usuario obtenerUsuarioPorId(int idUsuario) {
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("correo"),
                    rs.getString("contrasena"),
                    rs.getString("direccion"),
                    rs.getString("codigo_postal"),
                    rs.getString("telefono"),
                    rs.getDate("fecha_registro")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
