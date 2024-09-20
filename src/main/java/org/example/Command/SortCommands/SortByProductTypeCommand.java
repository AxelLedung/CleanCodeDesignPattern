package org.example.Command.SortCommands;

import org.example.Command.ICommand;
import org.example.Command.ProductCommands.ViewProductsCommand;
import org.example.Products.Product;
import org.example.Singleton.ProductRepository;

import java.util.List;

public class SortByProductTypeCommand  implements ICommand {
    ProductRepository productRepository = ProductRepository.getInstance();
    @Override
    public void execute() {
        insertionSortByProductType(productRepository.getProducts());
        ViewProductsCommand viewProductsCommand = new ViewProductsCommand();
        viewProductsCommand.execute();
    }
    public static void insertionSortByProductType(List<Product> products) {
        int n = products.size();
        for (int i = 1; i < n; ++i) {
            Product key = products.get(i);  // The current product to insert
            String keyClassName = key.getClass().getSimpleName(); // Get the class simple name for comparison
            int j = i - 1;

            // Move products that are greater than the key's class simple name to one position ahead
            while (j >= 0 && products.get(j).getClass().getSimpleName().compareTo(keyClassName) > 0) {
                products.set(j + 1, products.get(j)); // Shift the element to the right
                j = j - 1;
            }
            products.set(j + 1, key); // Insert the product at the correct position
        }
    }
}
