package org.example.Command;

public class Button {
    ICommand command;

    public Button(ICommand command){
        this.command = command;
    }
    public void pushButton() {
        command.execute();
    }
}
