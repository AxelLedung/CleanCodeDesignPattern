package org.example.Command.ProductCommands;

import org.example.Command.ICommand;
import org.example.Menu;
import org.example.Products.HardwareProduct;
import org.example.Products.SoftwareProduct;
import org.example.Singleton.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddProductCommand implements ICommand {
    Scanner scanner = new Scanner(System.in);
    int productId;
    String productName;
    int productCost;

    ArrayList<String> productTypeChoices = new ArrayList<>();
    HashMap<String, ICommand> productTypeCommands = new HashMap<>();

    ProductRepository productRepository = ProductRepository.getInstance();
    public AddProductCommand() {
        productTypeChoices.add("1. Hardware Product");
        productTypeChoices.add("2. Software Product");
        productTypeCommands.put("1", () -> productRepository.addProduct(new HardwareProduct(productId, productName, productCost)));
        productTypeCommands.put("2", () -> productRepository.addProduct(new SoftwareProduct(productId, productName, productCost)));
    }
    @Override
    public void execute() {
        String input;
        System.out.println("You are adding a product:");
        Menu addMenu = new Menu("Choose product type:", productTypeChoices, productTypeCommands);

        System.out.println("Input ID:");
        input = scanner.nextLine();
        if (!input.isEmpty()) {
            productId = Integer.parseInt(input);
        }
        else {
            return;
        }

        System.out.println("Input name:");
        input = scanner.nextLine();
        if (!input.isEmpty()) {
            productName = input;
        }
        else {
            return;
        }

        System.out.println("Input cost:");
        input = scanner.nextLine();
        if (!input.isEmpty()) {
            productCost = Integer.parseInt(input);
        }
        else {
            return;
        }
        var menu = addMenu.showMenu();
        if (menu != null) {
            menu.execute();
        }
    }
}
