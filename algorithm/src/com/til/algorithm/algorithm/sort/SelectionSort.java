package com.til.algorithm.algorithm.sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 2, 1};
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }

    private static void selectionSort(int[] arr) {
        selectionSort(arr, 0);
    }

    private static void selectionSort(int[] arr, int start) {
        if (start < arr.length - 1) {
            int min_index = start;
            for (int i = start; i < arr.length; i++) {
                if (arr[i] < arr[min_index]) {
                    min_index = i;
                }
            }
            swap(arr, start, min_index);
            selectionSort(arr, start + 1);
        }
    }

    private static void selectionSort2(int[] arr, int start) {
        if (start > arr.length - 1) return;
        int min_index = start;
        for (int i = start; i < arr.length; i++) {
            if (arr[min_index] > arr[i]) {
                min_index = i;
            }
        }
        swap(arr, start, min_index);
        selectionSort2(arr, start + 1);
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
