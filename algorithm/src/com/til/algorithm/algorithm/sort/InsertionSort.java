package com.til.algorithm.algorithm.sort;

/**
 *  삽입 정렬
 *
 *  거의 정렬된 경우 매우 효율적이다. 최선의 경우 O(N)
 *  단, 역순으로 되어 있는 경우 (= 최악의 경우) O(N^2)
 *  즉 데이터 상태에 따라서 성능 편차가 크다.
 *
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
                arr[j + 1] = arr[j];
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