package algorithm.sort;

import static algorithm.util.ArrayUtils.swap;

public class SelectionSort {

    private static void selectionSort(int[] arr, int start) {
        if (start < arr.length - 1) {
            int minIndex = start;
            for (int i = start; i < arr.length; i++) {
                if (arr[i] < arr[minIndex]) {
                    minIndex = i;
                }
            }
            swap(arr, start, minIndex);
            selectionSort(arr, start + 1);
        }
    }
}
