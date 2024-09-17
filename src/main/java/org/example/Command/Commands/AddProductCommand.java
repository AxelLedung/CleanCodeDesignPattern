package org.example.Command.Commands;

import org.example.Command.ICommand;

public class AddProductCommand implements ICommand {
    @Override
    public void execute() {
        System.out.println("Add Product!");
    }
}
