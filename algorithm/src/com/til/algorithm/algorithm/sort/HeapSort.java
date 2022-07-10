package com.til.algorithm.algorithm.sort;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {1, 99, 2, 33, 44, 11, 88};
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }

    private static void heapSort(int[] arr) {

        if (arr.length < 2) {
            return;
        }
        int root = getParent(arr.length - 1);

        for (int i = root; i >= 0; i--) {
            heapify(arr, i, arr.length - 1);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i - 1);
        }
    }

    private static int getParent(int child) {
        return (child - 1) / 2;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void heapify(int[] arr, int parentIdx, int lastIdx) {

        int root = parentIdx;
        int left = parentIdx * 2 + 1;
        int right = parentIdx * 2 + 2;

        if (left < lastIdx && arr[root] < arr[left]) {
            root = left;
        }

        if (right < lastIdx && arr[root] < arr[right]) {
            root = right;
        }

        if (parentIdx != root) {
            swap(arr, root, parentIdx);
            heapify(arr, root, lastIdx);
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
