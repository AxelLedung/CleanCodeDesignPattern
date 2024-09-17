package org.example;


import org.example.Command.CommandPattern;
import org.example.Singleton.ProductRepository;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = ProductRepository.getInstance();
        productRepository.addProduct(new Product(1, "Skruv", 15));
        productRepository.addProduct(new Product(2, "Hammare", 32));
        productRepository.addProduct(new Product(3, "Skruvdragare", 41));
        productRepository.addProduct(new Product(4, "Spik", 70));
        productRepository.addProduct(new Product(5, "Plåt", 34));

        System.out.println("Welcome to the Awesome Management of Products System - AMPS™");
        CommandPattern commandPattern = new CommandPattern();
        commandPattern.menu();
    }
}