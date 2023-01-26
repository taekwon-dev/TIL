package com.til.algorithm.algorithm.sort;

/**
 *  - 시간 복잡도 O(N^2)
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 4, 1};
        printArray(arr);
        insertionSort(arr);
        printArray(arr);
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > target) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = target;
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}