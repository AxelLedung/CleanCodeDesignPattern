package org.example.Command.ProductCommands;

import org.example.Command.Button;
import org.example.Command.ICommand;
import org.example.Command.SortCommands.SortByCostCommand;
import org.example.Command.SortCommands.SortByIdCommand;
import org.example.Command.SortCommands.SortByNameCommand;
import org.example.Command.SortCommands.SortByProductTypeCommand;
import org.example.Menu;
import org.example.Singleton.ProductRepository;

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

        sortMenuCommands.put("1", () -> new Button(new SortByIdCommand())); //Sort by ID
        sortMenuCommands.put("2", () -> new Button(new SortByNameCommand())); //Sort by Name
        sortMenuCommands.put("3", () -> new Button(new SortByCostCommand())); //Sort by Cost
        sortMenuCommands.put("4", () -> new Button(new SortByProductTypeCommand())); //Sort by Product type
    }
    @Override
    public void execute() {
        productRepository.displayProducts();
        Menu sortMenu = new Menu("Do you wish to sort the list?", sortMenuChoices, sortMenuCommands);
        var menu = sortMenu.showMenu();
        if (menu != null) {
            menu.execute();
        }
        else {
            System.out.println("Invalid choice.");
        }

    }
}
