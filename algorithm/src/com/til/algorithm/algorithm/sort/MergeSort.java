package com.til.algorithm.algorithm.sort;

/**
 *  - 시간 복잡도 : O(N log N)
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {7, 8, 3, 1, 6, 5, 2, 4};
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }

    private static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;

        mergeSort(arr, tmp, start, mid);
        mergeSort(arr, tmp, mid + 1, end);

        merge(arr, tmp, start, mid, end);
    }

    private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int index = start;
        int part1 = start;
        int part2 = mid + 1;

        while (part1 <= mid && part2 <= end) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index++] = tmp[part1++];
            } else {
                arr[index++] = tmp[part2++];
            }
        }

        // 7, 8, 3, 1, 6, 5, 2, 4
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
