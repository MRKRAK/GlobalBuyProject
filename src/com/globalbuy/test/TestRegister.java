package com.globalbuy.test;

import com.globalbuy.ui.RegisterUI;

public class TestRegister {

    public static void main(String[] args) {
        RegisterUI registerUI = new RegisterUI();

        // Datos del nuevo usuario
        String nombre = "Juan";
        String apellido = "Pérez";
        String correo = "juan.perez@example.com";
        String contrasena = "password123";
        String direccion = "Calle Falsa 123";
        String codigoPostal = "12345";
        String telefono = "555-1234";

        // Intentar registrar al nuevo usuario
        boolean registroExitoso = registerUI.registerUser(nombre, apellido, correo, contrasena, direccion, codigoPostal, telefono);

        if (registroExitoso) {
            System.out.println("Usuario registrado exitosamente");
        } else {
            System.out.println("Falló el registro del usuario");
        }
    }
}
