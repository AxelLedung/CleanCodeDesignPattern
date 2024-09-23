package org.example.Strategy;

import org.example.Products.Product;

import java.util.List;

public interface ISortStrategy {
    void sort(List<Product> products);
}
