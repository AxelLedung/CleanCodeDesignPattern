package org.example.Command;

import org.example.Command.SwingWindows.AddProductsWindow;

public class AddProductsCommand implements ICommand{
    @Override
    public void execute() {
        AddProductsWindow addProductsWindow = new AddProductsWindow();
    }
}
