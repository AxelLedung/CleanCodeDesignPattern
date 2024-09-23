package org.example.Command.ProductCommands;

import org.example.Command.ICommand;
import org.example.Singleton.ProductRepository;

public class RestoreProductCommand implements ICommand {
    ProductRepository productRepository = ProductRepository.getInstance();
    @Override
    public void execute() {
        productRepository.restoreProduct();
    }
}
