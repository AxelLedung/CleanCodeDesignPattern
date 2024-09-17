package org.example.Strategy;

import org.example.Strategy.SortingStrategies.QuickSortStrategy;

public class StrategyPattern {
    public void run() {
        Algorithm algorithm = new Algorithm();
        algorithm.setSortStrategy(new QuickSortStrategy());
        algorithm.sort();
    }
}
