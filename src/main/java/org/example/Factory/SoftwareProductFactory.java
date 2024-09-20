package org.example.Factory;

import org.example.Products.Product;
import org.example.Products.SoftwareProduct;

public class SoftwareProductFactory implements IProductFactory {
    @Override
    public Product createProduct(int id, String name, int cost) {

        return new SoftwareProduct(id, name, cost);
    }
}
