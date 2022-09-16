package com.til.algorithm.algorithm.sort;


/**
 * Selection Sort
 * <p>
 * 장점
 * 1. 추가 메모리 소비가 적다.
 * <p>
 * 단점
 * 1. 시간복잡도 O(N^2)
 * 2. 불안정 정렬
 */
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

    /**
     * @param start Selection Sort 는 정렬 과정에서 { Sorted / Unsorted } 로 구분되는데,
     *              따라서 Unsorted 의 시작점을 기준으로 재귀 함수를 호출
     */
    private static void selectionSort(int[] arr, int start) {
        if (start < arr.length - 1) {
            // 배열의 마지막 인덱스를 포인터로 지정할 떄는 이미 해당 배열의 정렬이 완료된 상태이므로,
            // 배열 사이즈 - 1 보다 작은 인덱스일 때만 로직 통과

            // 시작 위치가 가장 작은 값일 수 있기 때문에,
            // 배열 내 최솟값 인덱스 값은 정렬되지 않은 구간의 시작 지점도 포함
            int min_index = start;
            for (int i = start; i < arr.length; i++) {
                if (arr[i] < arr[min_index]) {
                    min_index = i;
                }
            }
            // 정렬되지 않은 구간 내에서 최솟값을 찾은 이후
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
