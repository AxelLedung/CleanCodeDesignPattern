package org.example.Command;

import org.example.Command.SwingWindows.EditProductsWindow;

public class EditProductsCommand implements ICommand{
    @Override
    public void execute() {
        EditProductsWindow editProductsWindow = new EditProductsWindow();
    }
}
