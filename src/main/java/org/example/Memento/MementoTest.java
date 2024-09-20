package org.example.Memento;

public class MementoTest {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("State1");
        caretaker.saveState(originator.createMemento());

        originator.setState("State2");
        caretaker.saveState(originator.createMemento());

        System.out.println("Current State: " + originator.getState());

        originator.restoreState(caretaker.getMemento(0));
        System.out.println("Restored to State: " + originator.getState());
    }
}
