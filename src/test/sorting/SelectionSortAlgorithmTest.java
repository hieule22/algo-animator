package test.sorting;

import main.sorting.SelectionSortAlgorithm;
import main.sorting.SortingAlgorithm;
import org.junit.Test;

import java.util.Comparator;

/**
 * @author Hieu Le
 * @version 11/26/15
 */
public class SelectionSortAlgorithmTest {

    @Test
    public void testSort() throws Exception {
        Integer[] elements = {1, 3, 5, 7, 9};
        SortingAlgorithm<Integer> sorter = new SelectionSortAlgorithm<>();
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