package org.example.Strategy.SortingStrategies;

import org.example.Strategy.ISortStrategy;

public class InsertionSortStrategy implements ISortStrategy {
    @Override
    public void sort() {
        System.out.println("sorting by InsertionSort.");
    }
    void sortById(int[] arrayToSort){
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
    void sortByName(int[] arrayToSort){
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
    void sortByCost(int[] arrayToSort){
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
