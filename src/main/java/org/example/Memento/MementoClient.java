package org.example.Memento;

public class MementoClient {
    Originator originator = new Originator();
    Caretaker caretaker = new Caretaker();

    public String getState() {
        return originator.getState();
    }
    public void setState(String state) {
        caretaker.push(originator.createMemento());
        originator.setState(state);
    }
    public void undo() {
        originator.restoreState(caretaker.pop());
    }
}
