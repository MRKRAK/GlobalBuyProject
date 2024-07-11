package com.globalbuy.test;

import com.globalbuy.ui.LoginUI;

public class TestLogin {
    public static void main(String[] args) {
        LoginUI loginUI = new LoginUI();
        String correo = "juan.perez@example.com";
        String contrasena = "password123";

        boolean loginExitoso = loginUI.login(correo, contrasena);

        if (loginExitoso) {
            System.out.println("Inicio de sesión exitoso para " + correo);
        } else {
            System.out.println("Inicio de sesión fallido para " + correo);
        }
    }
}
