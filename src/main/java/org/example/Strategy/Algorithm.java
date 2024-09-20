package org.example.Strategy;

import org.example.Singleton.ProductRepository;

public class Algorithm {
    ISortStrategy sortStrategy;

    public void setSortStrategy(ISortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }
    public void sort() {
        ProductRepository productRepository = ProductRepository.getInstance();
        sortStrategy.sort(productRepository);
    }
}
