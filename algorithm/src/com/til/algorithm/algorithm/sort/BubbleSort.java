package com.til.algorithm.algorithm.sort;

/**
 *  - 시간 복잡도 O(N^2) (정렬 여부 상관 없이)
 */
public class BubbleSort {

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

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     *  버블 정렬 최적화 :
     *  교환 과정에서 스와핑이 일어나지 않은 경우 이미 정렬이 완료됐다고 판단 가능
     */
    public static void bubbleSortOptimized(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            boolean swapped = false;
            for (int j = 0; j <= i; j++) {
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

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}