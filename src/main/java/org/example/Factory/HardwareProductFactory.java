package org.example.Factory;

import org.example.Products.HardwareProduct;
import org.example.Products.Product;

public class HardwareProductFactory implements IProductFactory {
    @Override
    public Product createProduct(int id, String name, int cost) {
        return new HardwareProduct(id, name, cost);
    }
}
