package com.til.algorithm.algorithm.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 3, 4};
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }

    private static void bubbleSort(int[] arr) {
        bubbleSort(arr, arr.length - 1);
    }

    private static void bubbleSort(int[] arr, int last) {
        if (last < 1) {
            return;
        }
        for (int idx = 1; idx <= last; idx++) {
            if (arr[idx - 1] > arr[idx]) {
                swap(arr, idx - 1, idx);
            }
        }
        bubbleSort(arr, last - 1);
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
