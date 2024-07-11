package com.globalbuy.test;

import com.globalbuy.ui.ProductManagementUI;

public class TestProductManagement {

    public static void main(String[] args) {
        ProductManagementUI productManagement = new ProductManagementUI();

        // Datos del nuevo producto
        String nombre = "Laptop";
        String descripcion = "Laptop de alto rendimiento con 16GB de RAM y 512GB SSD.";
        double precio = 1500.00;
        int categoriaID = 1; // Supongamos que la categoría ID 1 existe en la tabla Categoria
        int stock = 10;
        String imagenUrl = "https://example.com/laptop.jpg";

        // Intentar agregar el producto
        boolean isAdded = productManagement.addProduct(nombre, descripcion, precio, categoriaID, stock, imagenUrl);

        // Verificar si el producto se agregó correctamente
        if (isAdded) {
            System.out.println("El producto se agregó correctamente a la base de datos.");
        } else {
            System.out.println("Hubo un error al agregar el producto a la base de datos.");
        }
    }
}
