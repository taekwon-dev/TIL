package com.til.algorithm.algorithm.sort;

/**
 * Insertion Sort
 * <p>
 * 장점
 * 1. 추가 메모리 소비가 적다.
 * 2. 안정 정렬
 * <p>
 * 단점
 * 1. 시간복잡도 O(N^2)
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {7, 6, 2, 1, 4, 5};
        printArray(arr);
        insertionSort(arr);
        printArray(arr);
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > target) {
                // 처음 통과할 때 j + 1 = i (= target)
                arr[j + 1] = arr[j];
                // 비교 대상 지정 포인트 왼쪽으로 이동
                j--;
            }
            arr[j + 1] = target;

        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}