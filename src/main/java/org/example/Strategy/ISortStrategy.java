package org.example.Strategy;

import org.example.Products.Product;
import org.example.Singleton.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public interface ISortStrategy {
    void sort(List<Product> products);
}
