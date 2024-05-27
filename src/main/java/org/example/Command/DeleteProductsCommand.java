package org.example.Command;

import org.example.Command.SwingWindows.DeleteProductsWindow;

public class DeleteProductsCommand implements ICommand{
    @Override
    public void execute() {
        DeleteProductsWindow deleteProductWindow = new DeleteProductsWindow();
    }
}
