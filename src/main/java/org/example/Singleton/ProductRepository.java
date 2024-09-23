package org.example.Singleton;

import com.google.gson.*;
import org.example.Memento.MementoClient;
import org.example.Products.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    private static ProductRepository instance;
    MementoClient mementoClient = new MementoClient();
    Gson gson = new Gson();

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
        mementoClient.setState(gson.toJson(product));
        if (products.remove(product))
        {
            System.out.println("Succesfully removed: ID: " + product.getId() + ", Name: " + product.getName());
        }
        else {
            System.out.println("Could not remove product at ID: " + product.getId());
        }
    }
    public void restoreProduct() {
        try {
            Product product = gson.fromJson(mementoClient.getState(), Product.class);
            if (product != null) {
                products.add(product);
                System.out.println(product.getName() + " was restored.");
                mementoClient.undo();
            }
            else {
                System.out.println("No product to restore.");
            }
        }
        catch (Exception e) {

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
