package org.example.Command.ProductCommands;

import org.example.Command.ICommand;
import org.example.Menu;
import org.example.Singleton.ProductRepository;
import org.example.Strategy.SortingStrategies.SortByCostStrategy;
import org.example.Strategy.SortingStrategies.SortByIdStrategy;
import org.example.Strategy.SortingStrategies.SortByNameStrategy;
import org.example.Strategy.SortingStrategies.SortByProductClass;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewProductsCommand implements ICommand {
    ArrayList<String> sortMenuChoices = new ArrayList<>();
    HashMap<String, ICommand> sortMenuCommands = new HashMap<>();
    ProductRepository productRepository = ProductRepository.getInstance();

    public ViewProductsCommand() {
        sortMenuChoices.add("1. Sort by ID");
        sortMenuChoices.add("2. Sort by Name");
        sortMenuChoices.add("3. Sort by Cost");
        sortMenuChoices.add("4. Sort by Product type");

        sortMenuCommands.put("1", () -> new SortByIdStrategy().sort(productRepository.getProducts())); //Sort by ID
        sortMenuCommands.put("2", () -> new SortByNameStrategy().sort(productRepository.getProducts())); //Sort by Name
        sortMenuCommands.put("3", () -> new SortByCostStrategy().sort(productRepository.getProducts())); //Sort by Cost
        sortMenuCommands.put("4", () -> new SortByProductClass().sort(productRepository.getProducts())); //Sort by Product type
    }
    @Override
    public void execute() {
        productRepository.displayProducts();
        Menu sortMenu = new Menu("Do you wish to sort the list?", sortMenuChoices, sortMenuCommands);
        var menu = sortMenu.showMenu();
        if (menu != null) {
            menu.execute();
        }
    }
}
