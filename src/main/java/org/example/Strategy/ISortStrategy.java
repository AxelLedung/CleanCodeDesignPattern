package org.example.Strategy;

public interface ISortStrategy {
    void sort();
    abstract void sortById();
    abstract void sortByName();
    abstract void sortByCost();

    void sortById(int[] arrayToSort, int start, int end);

    void sortByName(int[] arrayToSort, int start, int end);

    void sortByCost(int[] arrayToSort, int start, int end);
}
