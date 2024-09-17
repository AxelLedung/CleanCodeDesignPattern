package org.example.Command.Commands;

import org.example.Command.ICommand;

public class EditProductCommand implements ICommand {
    @Override
    public void execute() {
        System.out.println("Edit Product!");
    }
}
