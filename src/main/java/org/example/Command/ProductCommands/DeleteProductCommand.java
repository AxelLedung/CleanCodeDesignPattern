package org.example.Command.ProductCommands;

import org.example.Command.ICommand;
import org.example.Menu;
import org.example.Products.HardwareProduct;
import org.example.Products.Product;
import org.example.Products.SoftwareProduct;
import org.example.Singleton.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DeleteProductCommand implements ICommand {
    String input;
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> productChoices = new ArrayList<>();
    HashMap<String, ICommand> productCommands = new HashMap<>();

    ProductRepository productRepository = ProductRepository.getInstance();
    public DeleteProductCommand() {
        int i = 0;
        for (Product product : productRepository.getProducts()) {
            productChoices.add("Id:" + product.getId() + ". Name: " + product.getName());
            productCommands.put(String.valueOf(product.getId()), () -> productRepository.deleteProduct(product));
        }
    }
    @Override
    public void execute() {
        Menu deleteMenu = new Menu("Choose product to delete by inputting ID.", productChoices, productCommands);
        var menu = deleteMenu.showMenu();
        if (menu != null) {
            menu.execute();
        }
        else {
            System.out.println("Invalid choice.");
        }

    }
}
