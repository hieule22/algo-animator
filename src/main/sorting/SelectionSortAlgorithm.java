package main.sorting;

import java.util.Comparator;

/**
 * @author Hieu Le
 * @version 11/26/15
 */
public class SelectionSortAlgorithm<T> implements SortingAlgorithm<T> {

    @Override
    public void sort(T[] arr, Comparator<? super T> comparator) {
        for (int i = 0; i < arr.length - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; ++j) {
                if (comparator.compare(arr[j], arr[minIndex]) < 0) {
                    minIndex = i;
                }
            }

            if (minIndex != i) {
                T temp = arr[i];
                arr[i] = temp;
                arr[minIndex] = temp;
            }
        }
    }
}
