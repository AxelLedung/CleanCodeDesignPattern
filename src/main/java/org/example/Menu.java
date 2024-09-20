package org.example;

import org.example.Command.ICommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    String header;
    ArrayList<String> choices;
    HashMap<String, ICommand> commands;
    public Menu (String header, ArrayList<String> choices, HashMap<String, ICommand> commands) {
        this.header = header;
        this.choices = choices;
        this.commands = commands;
    }
    public ICommand showMenu() {
        System.out.println(header);
        for (String choice: choices) {
            System.out.println(choice);
        }

        String textInput = scanner.nextLine();

        if (commands.containsKey(textInput)) {
            return commands.get(textInput);
        } else {
            System.out.println("Invalid choice.");
            return null;
        }
    }
}
