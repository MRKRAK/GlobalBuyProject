package com.globalbuy.test;

import com.globalbuy.manager.UsuarioManager;
import com.globalbuy.model.Usuario;

public class TestUsuarioManager {

    public static void main(String[] args) {
        UsuarioManager usuarioManager = new UsuarioManager();

        // Prueba de agregar usuario
        Usuario nuevoUsuario = new Usuario(1, "Juan", "Pérez", "juan.perez@example.com", "123456", "Calle 123", "110111", "1234567890", new java.util.Date());
        boolean agregado = usuarioManager.actualizarUsuario(nuevoUsuario);
        if (agregado) {
            System.out.println("Usuario actualizado exitosamente.");
        } else {
            System.out.println("Error al actualizar el usuario.");
        }

        // Prueba de obtener usuario por ID
        Usuario usuario = usuarioManager.obtenerUsuarioPorId(1);
        if (usuario != null) {
            System.out.println("Usuario encontrado: " + usuario.getNombre() + " " + usuario.getApellido());
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }
}
