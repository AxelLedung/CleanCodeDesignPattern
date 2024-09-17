package org.example.Strategy;

public class Algorithm {
    ISortStrategy sortStrategy;

    public void setSortStrategy(ISortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }
    public void sort() {
        sortStrategy.sort();
    }
}
