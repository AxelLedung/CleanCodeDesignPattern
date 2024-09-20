package org.example.Factory;

import org.example.Products.Product;

public interface IProductFactory {
    Product createProduct(int id, String name, int cost);
}
