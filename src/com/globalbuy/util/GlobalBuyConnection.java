package com.globalbuy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GlobalBuyConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/global_buy";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.err.println("Error al conectar a la base de datos: " + ex.getMessage());
            return null;
        }
    }
}