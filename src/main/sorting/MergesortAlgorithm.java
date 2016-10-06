package main.sorting;

import java.util.Comparator;

/**
 * @author Hieu Le
 * @version 11/26/15
 */
public class MergesortAlgorithm<T> implements SortingAlgorithm<T> {

    @Override
    public void sort(T[] arr, Comparator<? super T> comparator) {
        Object[] aux = new Object[arr.length];
        sortImpl(arr, aux, 0, arr.length - 1, comparator);
    }

    private void sortImpl(T[] arr, Object[] buffer, int low, int high,
                          Comparator<? super T> comparator) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sortImpl(arr, buffer, low, mid, comparator);
        sortImpl(arr, buffer, mid + 1, high, comparator);
        merge(arr, buffer, low, mid, high, comparator);
    }

    private void merge(T[] arr, Object[] buffer, int low, int mid, int high,
                       Comparator<? super T> comparator) {
        // Copy to buffer
        for (int k = low; k <= high; ++k) {
            buffer[k] = arr[k];
        }

        // Merge back to arr[]
        int i = low, j = mid + 1;
        for (int k = low; k <= high; ++k) {
            if (i > mid)
                arr[k] = (T)buffer[j++];
            else if (j > high)
                arr[k] = (T)buffer[i++];
            else if (comparator.compare((T)buffer[j], (T)buffer[i]) < 0)
                arr[k] = (T)buffer[j++];
            else
                arr[k] = (T)buffer[i++];
        }
    }
}
