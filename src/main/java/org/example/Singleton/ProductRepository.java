package org.example.Singleton;

import org.example.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    private static ProductRepository instance;

    public static ProductRepository getInstance()  {
        if (instance == null) {
            instance = new ProductRepository();
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getId() + "," + product.getName() + "," + product.getCost());
    }

    public List<Product> getProducts() {
        return products;
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("Product List:");
            for (Product product : products) {
                System.out.println("ID: " + product.getId() + ", Name: " + product.getName() + ", Price: " + product.getCost());
            }
        }
    }

}
