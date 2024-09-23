package org.example.Memento;

import java.util.LinkedList;

public class Caretaker {
    private LinkedList<Memento> previous = new LinkedList<>();

    public void push(Memento memento) {
        previous.push(memento);
    }
    public Memento pop() {
        if (!previous.isEmpty()) {
            return previous.pop();
        }
        else {
            System.out.println("No products to restore.");
            return null;
        }
    }
}
