package org.example.Command.SortCommands;

import org.example.Command.ICommand;
import org.example.Command.ProductCommands.ViewProductsCommand;
import org.example.Products.Product;
import org.example.Singleton.ProductRepository;

import java.util.List;

public class SortByCostCommand implements ICommand {
    ProductRepository productRepository = ProductRepository.getInstance();
    @Override
    public void execute() {
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
