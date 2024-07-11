package com.globalbuy.test;

import com.globalbuy.ui.CatalogUI;
import com.globalbuy.ui.Product;
import java.util.List;

public class TestCatalog {

    public static void main(String[] args) {
        CatalogUI catalogUI = new CatalogUI();

        // Obtener la lista de productos
        List<Product> products = catalogUI.getAllProducts();

        // Imprimir los detalles de cada producto
        if (products.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}
