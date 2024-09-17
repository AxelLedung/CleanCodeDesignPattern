package org.example.Strategy.SortingStrategies;

import org.example.Strategy.ISortStrategy;

import static java.util.Collections.swap;

public class QuickSortStrategy implements ISortStrategy {
    @Override
    public void sort() {
        System.out.println("sorting by QuickSort.");
    }
    int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int p_index = start;
        for (int i = start; i < end; i++){
            if(array[i] < pivot){
                swap(array, i, p_index);
                p_index++;
            }
        }
        swap(array, p_index, end);
        return p_index;
    }
    @Override
    public void sortById(int[] arrayToSort, int start, int end) {
        if(start < end){
            int p_index =
                    partition(
                            arrayToSort, start, end);
            sortById(
                    arrayToSort, start,
                    p_index-1);
            sortById(
                    arrayToSort,
                    p_index+1, end);
        }
    }
    @Override
    public void sortByName(int[] arrayToSort, int start, int end) {
        if(start < end){
            int p_index =
                    partition(
                            arrayToSort, start, end);
            sortById(
                    arrayToSort, start,
                    p_index-1);
            sortById(
                    arrayToSort,
                    p_index+1, end);
        }
    }
    @Override
    public void sortByCost(int[] arrayToSort, int start, int end){
        if(start < end){
            int p_index =
                    partition(
                            arrayToSort, start, end);
            sortById(
                    arrayToSort, start,
                    p_index-1);
            sortById(
                    arrayToSort,
                    p_index+1, end);
        }
    }
}
