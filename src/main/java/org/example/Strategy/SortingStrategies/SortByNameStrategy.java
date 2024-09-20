package org.example.Strategy.SortingStrategies;

import org.example.Command.ProductCommands.ViewProductsCommand;
import org.example.Products.Product;
import org.example.Singleton.ProductRepository;
import org.example.Strategy.ISortStrategy;

import java.util.List;

public class SortByNameStrategy implements ISortStrategy {
    ProductRepository productRepository = ProductRepository.getInstance();

    @Override
    public void sort(List<Product> products) {
        quickSortByName(productRepository.getProducts(), 0, productRepository.getProducts().size() - 1);
        ViewProductsCommand viewProductsCommand = new ViewProductsCommand();
        viewProductsCommand.execute();
    }
    private static void quickSortByName(List<Product> products, int low, int high) {

        if (low < high) {
            int pi = partition(products, low, high);
            quickSortByName(products, low, pi - 1);
            quickSortByName(products, pi + 1, high);
        }
    }

    private static int partition(List<Product> products, int low, int high) {
        Product pivot = products.get(high);
        String pivotName = pivot.getName();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            String currentName = products.get(j).getName();
            if (currentName.compareTo(pivotName) < 0) {
                i++;
                // Swap products[i] and products[j]
                Product temp = products.get(i);
                products.set(i, products.get(j));
                products.set(j, temp);
            }
        }

        // Swap products[i + 1] and products[high] (or pivot)
        Product temp = products.get(i + 1);
        products.set(i + 1, products.get(high));
        products.set(high, temp);

        return i + 1;
    }
}
