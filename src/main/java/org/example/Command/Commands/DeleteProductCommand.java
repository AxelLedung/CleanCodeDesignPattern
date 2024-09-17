package org.example.Command.Commands;

import org.example.Command.ICommand;

public class DeleteProductCommand implements ICommand {
    @Override
    public void execute() {
        System.out.println("Delete Product!");
    }
}
