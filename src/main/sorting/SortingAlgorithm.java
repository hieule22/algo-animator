package main.sorting;

import java.util.Comparator;

/**
 * Base interface for all main.sorting algorithm.
 * @author Hieu Le
 * @version 11/26/15
 */
public interface SortingAlgorithm<T> {
    /**
     * Sorts a given array.
     * @param arr the array to be sorted
     * @param comparator the comparison mechanism to use
     */
    void sort(T[] arr, Comparator<? super T> comparator);
}
