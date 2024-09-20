package org.example;

import org.example.Command.Button;
import org.example.Command.ProductCommands.AddProductCommand;
import org.example.Command.ProductCommands.DeleteProductCommand;
import org.example.Command.ProductCommands.EditProductCommand;
import org.example.Command.ProductCommands.ViewProductsCommand;
import org.example.Command.ICommand;
import org.example.Command.SortCommands.SortByCostCommand;
import org.example.Command.SortCommands.SortByIdCommand;
import org.example.Command.SortCommands.SortByNameCommand;
import org.example.Command.SortCommands.SortByProductTypeCommand;
import org.example.Factory.HardwareProductFactory;
import org.example.Factory.SoftwareProductFactory;
import org.example.Products.HardwareProduct;
import org.example.Products.SoftwareProduct;
import org.example.Singleton.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class InitializerService {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<String> mainMenuChoices = new ArrayList<>();
    private HashMap<String, ICommand> mainMenuCommands = new HashMap<>();
    private ArrayList<String> productTypeChoices = new ArrayList<>();
    private HashMap<String, ICommand> productTypeCommands = new HashMap<>();
    private ArrayList<String> sortMenuChoices = new ArrayList<>();
    private HashMap<String, ICommand> sortMenuCommands = new HashMap<>();
    private ArrayList<String> sortAlgorithmChoices = new ArrayList<>();
    private HashMap<String, ICommand> sortAlgorthmCommands = new HashMap<>();
    private HardwareProductFactory hardwareProductFactory = new HardwareProductFactory();
    private SoftwareProductFactory softwareProductFactory = new SoftwareProductFactory();
    private ProductRepository productRepository = ProductRepository.getInstance();

    public InitializerService() {
        initializeProducts();
        initializeMenus();

    }
    private void initializeProducts() {
        productRepository.addProduct(new HardwareProduct(0, "MSI Geforce 4080", 10000));
        productRepository.addProduct(new HardwareProduct(1, "Corsair 750W PSU", 700));
        productRepository.addProduct(new HardwareProduct(2, "Corsair 32GB RAMM", 1100));
        productRepository.addProduct(new SoftwareProduct(4, "Windows 10 OEM", 300));
        productRepository.addProduct(new SoftwareProduct(4, "Windows 11 OEM", 500));
        productRepository.addProduct(new SoftwareProduct(4, "Avast 'Anti'-Virus Program", 2500));
        productRepository.addProduct(new SoftwareProduct(4, "Avast Virus Program", 25));
    }
    private void initializeMenus() {
        mainMenuChoices.add("1. View Products.");
        mainMenuChoices.add("2. Add Product.");
        mainMenuChoices.add("3. Edit Product");
        mainMenuChoices.add("4. Delete Product");

        mainMenuCommands.put("1", () -> new Button(new ViewProductsCommand()).pressButton()); //View Products
        mainMenuCommands.put("2", () -> new Button(new AddProductCommand()).pressButton()); //Add Product
        mainMenuCommands.put("3", () -> new Button(new EditProductCommand()).pressButton()); //Edit Product
        mainMenuCommands.put("4", () -> new Button(new DeleteProductCommand()).pressButton()); //Delete Product

        sortMenuChoices.add("1. Sort by ID");
        sortMenuChoices.add("2. Sort by Name");
        sortMenuChoices.add("3. Sort by Cost");
        sortMenuChoices.add("4. Sort by Product type");

        sortMenuCommands.put("1", () -> new Button(new SortByIdCommand())); //Sort by ID
        sortMenuCommands.put("2", () -> new Button(new SortByNameCommand())); //Sort by Name
        sortMenuCommands.put("3", () -> new Button(new SortByCostCommand())); //Sort by Cost
        sortMenuCommands.put("4", () -> new Button(new SortByProductTypeCommand())); //Sort by Product type
    }
    public void run() {
        Menu mainMenu = new Menu("Welcome to the Awesome Management of Products System - AMPS™", mainMenuChoices, mainMenuCommands);
        mainMenu.showMenu().execute();
    }

}
