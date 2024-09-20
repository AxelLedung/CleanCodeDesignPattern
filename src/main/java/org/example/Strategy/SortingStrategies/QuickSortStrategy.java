package org.example.Strategy.SortingStrategies;

import org.example.Singleton.ProductRepository;
import org.example.Strategy.ISortStrategy;

import java.util.List;
import java.util.Collections;

public class QuickSortStrategy implements ISortStrategy {
    @Override
    public void sort(ProductRepository productRepository) {
        System.out.println("sorting by QuickSort.");
    }
    // Partition method adapted for List<Integer>
    public int partition(List<Integer> list, int start, int end) {
        int pivot = list.get(end); // Get the pivot element
        int p_index = start;

        for (int i = start; i < end; i++) {
            if (list.get(i) < pivot) {
                Collections.swap(list, i, p_index); // Swap elements in the list
                p_index++;
            }
        }
        Collections.swap(list, p_index, end); // Move pivot to the correct position
        return p_index;
    }

    // Quick sort method adapted for List<Integer>
    public void sortById(List<Integer> listToSort, int start, int end) {
        if (start < end) {
            int p_index = partition(listToSort, start, end);
            sortById(listToSort, start, p_index - 1); // Sort left sublist
            sortById(listToSort, p_index + 1, end);   // Sort right sublist
        }
    }
    public void sortByName(List<Integer> arrayToSort, int start, int end) {
        if(start < end){
            int p_index =
                    partition(
                            arrayToSort, start, end);
            sortByName(
                    arrayToSort, start,
                    p_index-1);
            sortByName(
                    arrayToSort,
                    p_index+1, end);
        }
    }
    public void sortByCost(List<Integer> arrayToSort, int start, int end){
        if(start < end){
            int p_index =
                    partition(
                            arrayToSort, start, end);
            sortByCost(
                    arrayToSort, start,
                    p_index-1);
            sortByCost(
                    arrayToSort,
                    p_index+1, end);
        }
    }
}

/*
import java.util.List;
import java.util.Collections;

public class QuickSort {

    // Partition method adapted for List<Integer>
    public int partition(List<Integer> list, int start, int end) {
        int pivot = list.get(end); // Get the pivot element
        int p_index = start;

        for (int i = start; i < end; i++) {
            if (list.get(i) < pivot) {
                Collections.swap(list, i, p_index); // Swap elements in the list
                p_index++;
            }
        }
        Collections.swap(list, p_index, end); // Move pivot to the correct position
        return p_index;
    }

    // Quick sort method adapted for List<Integer>
    public void sortById(List<Integer> listToSort, int start, int end) {
        if (start < end) {
            int p_index = partition(listToSort, start, end);
            sortById(listToSort, start, p_index - 1); // Sort left sublist
            sortById(listToSort, p_index + 1, end);   // Sort right sublist
        }
    }

    // Main method to test sorting
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        List<Integer> list = List.of(3, 6, 8, 10, 1, 2, 1);

        // Since List.of creates an immutable list, convert it to a mutable list
        List<Integer> mutableList = new ArrayList<>(list);

        quickSort.sortById(mutableList, 0, mutableList.size() - 1);
        System.out.println(mutableList);
    }
}
 */