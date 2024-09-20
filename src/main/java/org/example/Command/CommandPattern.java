package org.example.Command;

import org.example.Command.ProductCommands.AddProductCommand;
import org.example.Command.ProductCommands.DeleteProductCommand;
import org.example.Command.ProductCommands.EditProductCommand;
import org.example.Command.ProductCommands.ViewProductsCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CommandPattern {
    Scanner scanner = new Scanner(System.in);

    ArrayList<String> choices = new ArrayList<>();
    HashMap<String, ICommand> commandHashMap = new HashMap<>();

    Button viewProductsButton = new Button(new ViewProductsCommand());
    Button addProductButton = new Button(new AddProductCommand());
    Button editProductButton = new Button(new EditProductCommand());
    Button deleteProductButton = new Button(new DeleteProductCommand());

    public CommandPattern() {
        choices.add("1. View all Products.");
        choices.add("2. Add a Product.");
        choices.add("3. Edit a Product.");
        choices.add("4. Delete a Product.");

        commandHashMap.put("1", () -> viewProductsButton.pressButton());
        commandHashMap.put("2", () -> addProductButton.pressButton());
        commandHashMap.put("3", () -> editProductButton.pressButton());
        commandHashMap.put("4", () -> deleteProductButton.pressButton());
    }
    public void menu() {
        System.out.println("What would you like to do?");
        for (String choice: choices) {
            System.out.println(choice);
        }

        String input = scanner.nextLine();

        if (commandHashMap.containsKey(input)) {
            commandHashMap.get(input).execute();
        }
        else {
            System.out.println("Not an option.");
        }
    }

}
