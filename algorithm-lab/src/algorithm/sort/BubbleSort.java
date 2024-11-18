package algorithm.sort;

import static algorithm.util.ArrayUtils.swap;

public class BubbleSort {

    private static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            boolean swapped = false;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}
