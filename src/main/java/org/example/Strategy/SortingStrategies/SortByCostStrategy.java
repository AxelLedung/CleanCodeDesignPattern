package org.example.Strategy.SortingStrategies;

import org.example.Command.ProductCommands.ViewProductsCommand;
import org.example.Products.Product;
import org.example.Singleton.ProductRepository;
import org.example.Strategy.ISortStrategy;

import java.util.List;

public class SortByCostStrategy implements ISortStrategy {
    ProductRepository productRepository = ProductRepository.getInstance();
    @Override
    public void sort(List<Product> products) {
        insertionSortByCost(productRepository.getProducts());
        ViewProductsCommand viewProductsCommand = new ViewProductsCommand();
        viewProductsCommand.execute();
    }
    public static void insertionSortByCost(List<Product> products) {
        int n = products.size();
        for (int i = 1; i < n; ++i) {
            Product key = products.get(i);  // The current product to insert
            double keyCost = key.getCost(); // Get the cost of the current product
            int j = i - 1;

            // Move products that are greater than the keyCost to one position ahead
            while (j >= 0 && products.get(j).getCost() > keyCost) {
                products.set(j + 1, products.get(j)); // Shift the element to the right
                j = j - 1;
            }
            products.set(j + 1, key); // Insert the product at the correct position
        }
    }
}
