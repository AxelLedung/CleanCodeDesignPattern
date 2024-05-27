package org.example.Command;

import org.example.Command.SwingWindows.ShowProductsWindow;

public class ShowProductsCommand implements ICommand{
    @Override
    public void execute() {
        ShowProductsWindow showProductsWindow = new ShowProductsWindow();
    }

}
