package org.example.Singleton;

import org.example.Products.Product;

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
        System.out.println(product.getClass().getSimpleName() + " added: " + product.getId() + "," + product.getName() + "," + product.getCost());
    }
    public void deleteProduct(Product product) {
        if (products.remove(product))
        {
            System.out.println("Succesfully removed: ID: " + product.getId() + ", Name: " + product.getName());
        }
        else {
            System.out.println("Could not remove product at ID: " + product.getId());
        }
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
                System.out.println(
                        "ID: " + product.getId() +
                        ", Name: " + product.getName() +
                        ", Price: " + product.getCost() +
                        ", Type: " + product.getClass().getSimpleName()
                );
            }
        }
    }

}
