package test.sorting;

import main.sorting.MergesortAlgorithm;
import main.sorting.SortingAlgorithm;

import java.util.Comparator;

/**
 * @author Hieu Le
 * @version 11/26/15
 */
public class MergesortAlgorithmTest {

    @org.junit.Test
    public void testSort() throws Exception {
        Integer[] elements = {1, 3, 5, 7, 9};
        SortingAlgorithm<Integer> sorter = new MergesortAlgorithm<>();
        sorter.sort(elements, Integer::compareTo);
        assert isSorted(elements, Integer::compareTo);
    }

    private static <T> boolean isSorted(T[] arr, Comparator<T> comparator) {
        for (int i = 1; i < arr.length; ++i) {
            if (comparator.compare(arr[i - 1], arr[i]) > 0)
                return false;
        }
        return true;
    }
}