package com.til.algorithm.algorithm.sort;

/**
 *  - 시간 복잡도 O(N^2)
 *  - (n - 1) + (n - 2) + (n - 3 ) + ... + 2 + 1 = n(n - 1) / 2
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 4, 1};
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }

    private static void selectionSort(int[] arr) {
        selectionSort(arr, 0);
    }

    private static void selectionSort(int[] arr, int start) {
        if (start > arr.length - 1) {
            return;
        }
        int minIdx = start;
        for (int idx = start; idx < arr.length; idx++) {
            if (arr[minIdx] > arr[idx]) {
                minIdx = idx;
            }
        }
        swap(arr, start, minIdx);
        selectionSort(arr, start + 1);
    }

    private static void swap(int[] arr, int former, int latter) {
        int tmp = arr[former];
        arr[former] = arr[latter];
        arr[latter] = tmp;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}