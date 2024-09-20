package org.example.Strategy.SortingStrategies;

import org.example.Singleton.ProductRepository;
import org.example.Strategy.ISortStrategy;

public class InsertionSortStrategy implements ISortStrategy {
    @Override
    public void sort(ProductRepository productRepository) {
        System.out.println("sorting by InsertionSort.");
    }
    public void sortById(int[] arrayToSort){
        for(int i = 1; i < arrayToSort.length; i++){
            int temp = arrayToSort[i];
            int j=i;
            while(j>0 && arrayToSort[j-1] > temp){
                arrayToSort[j] = arrayToSort[j-1];
                j--;
            }
            arrayToSort[j] = temp;
        }
    }
    public void sortByName(int[] arrayToSort){
        for(int i = 1; i < arrayToSort.length; i++){
            int temp = arrayToSort[i];
            int j=i;
            while(j>0 && arrayToSort[j-1] > temp){
                arrayToSort[j] = arrayToSort[j-1];
                j--;
            }
            arrayToSort[j] = temp;
        }
    }
    public void sortByCost(int[] arrayToSort){
        for(int i = 1; i < arrayToSort.length; i++){
            int temp = arrayToSort[i];
            int j=i;
            while(j>0 && arrayToSort[j-1] > temp){
                arrayToSort[j] = arrayToSort[j-1];
                j--;
            }
            arrayToSort[j] = temp;
        }
    }
}
