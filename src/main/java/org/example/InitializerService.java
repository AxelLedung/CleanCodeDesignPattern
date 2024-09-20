package org.example;

import org.example.Command.Button;
import org.example.Command.ProductCommands.AddProductCommand;
import org.example.Command.ProductCommands.DeleteProductCommand;
import org.example.Command.ProductCommands.ViewProductsCommand;
import org.example.Command.ICommand;
import org.example.Factory.HardwareProductFactory;
import org.example.Factory.SoftwareProductFactory;
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
        initializeMainMenu();

    }

    private void initializeProducts() {
        productRepository.addProduct(hardwareProductFactory.createProduct(0, "MSI Geforce 4080", 10000));
        productRepository.addProduct(hardwareProductFactory.createProduct(1, "Corsair 750W PSU", 10000));
        productRepository.addProduct(hardwareProductFactory.createProduct(2, "Corsair DDR5 16GB RAMM", 10000));
        productRepository.addProduct(hardwareProductFactory.createProduct(3, "Intel 10400K I5 3.2GHz", 10000));
        productRepository.addProduct(softwareProductFactory.createProduct(4, "Windows 11 OEM", 600));
        productRepository.addProduct(softwareProductFactory.createProduct(5, "Avast 'Anti'-virus", 50));
        productRepository.addProduct(softwareProductFactory.createProduct(6, "Avast Virus program", 500));
    }
    private void initializeMainMenu() {
        mainMenuChoices.add("1. View Products.");
        mainMenuChoices.add("2. Add Product.");
        mainMenuChoices.add("3. Delete Product");

        mainMenuCommands.put("1", () -> new Button(new ViewProductsCommand()).pressButton()); //View Products
        mainMenuCommands.put("2", () -> new Button(new AddProductCommand()).pressButton()); //Add Products
        mainMenuCommands.put("3", () -> new Button(new DeleteProductCommand()).pressButton()); //Delete Product
    }
    public void run() {
        while(true) {
            Menu mainMenu = new Menu("Welcome to the Awesome Management of Products System - AMPS™", mainMenuChoices, mainMenuCommands);
            mainMenu.showMenu().execute();
        }
    }

}
