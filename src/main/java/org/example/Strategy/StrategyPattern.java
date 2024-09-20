package org.example.Strategy;

import org.example.Command.ICommand;
import org.example.Strategy.SortingStrategies.InsertionSortStrategy;
import org.example.Strategy.SortingStrategies.QuickSortStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StrategyPattern {
    Scanner scanner = new Scanner(System.in);

    ArrayList<String> choices = new ArrayList<>();
    HashMap<String, ISortStrategy> commandHashMap = new HashMap<>();

    public StrategyPattern() {
        choices.add("1. Quick sort.");
        choices.add("2. Insertion sort.");

        commandHashMap.put("1", (productRepository) -> new QuickSortStrategy());
        commandHashMap.put("2", (productRepository) -> new InsertionSortStrategy());
    }
    public void menu() {
        System.out.println("Choose sorting algorithm.");
        for (String choice: choices) {
            System.out.println(choice);
        }

        String input = scanner.nextLine();
        Algorithm algorithm = new Algorithm();
        algorithm.setSortStrategy(new QuickSortStrategy());
        if (commandHashMap.containsKey(input)) {
            algorithm.setSortStrategy(commandHashMap.get(input));
        }
        else {
            System.out.println("Not an option.");
        }

        algorithm.sort();
    }
}

/*

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
 */