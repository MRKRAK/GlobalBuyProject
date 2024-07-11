package com.globalbuy.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionTest {

    public static void main(String[] args) {
        System.out.println("Probando la conexión a la base de datos...");

        Connection conn = null;
        try {
            // Configurar la conexión
            String url = "jdbc:mysql://localhost:3306/GLOBAL_BUY";
            String usuario = "root";
            String contraseña = "root";

            // Intentar conectar
            conn = DriverManager.getConnection(url, usuario, contraseña);

            // Verificar si la conexión fue exitosa
            if (conn != null) {
                System.out.println("Conexión exitosa a la base de datos");
            } else {
                System.out.println("No se pudo establecer conexión a la base de datos");
            }

        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        } finally {
            // Cerrar la conexión al finalizar
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
