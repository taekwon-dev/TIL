package com.til.algorithm.algorithm.sort;


/**
 * Quick Sort
 * <p>
 * O(NlogN) ~ O(N^2)
 * <p>
 * https://st-lab.tistory.com/250
 * https://www.youtube.com/watch?v=EuJSDghD4z8
 * https://www.youtube.com/watch?v=7BDzle2n47c
 * <p>
 * 비교 정렬
 * 제자리 정렬
 * 불안정 정렬
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3, 9, 4, 7, 5, 0};
        printArray(arr);
        quickSort(arr);
        printArray(arr);
    }

    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        int part2 = partition(arr, start, end);
        if (start < part2 - 1) {
            quickSort(arr, start, part2 - 1);
        }
        if (part2 < end) {
            quickSort(arr, part2, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        System.out.println(start + " ~ " + end);
        int pivot = arr[(start + end) / 2];
        while (start <= end) {
            while (arr[start] < pivot) start++;
            while (pivot < arr[end]) end--;
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
