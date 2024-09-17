package org.example.Command.Commands;

import org.example.Command.ICommand;
import org.example.Product;
import org.example.Singleton.ProductRepository;

public class ViewProductsCommand implements ICommand {
    @Override
    public void execute() {
        ProductRepository productRepository = ProductRepository.getInstance();
        productRepository.displayProducts();
    }
}
