package com.til.algorithm.algorithm.sort;

/**
 *  버블 정렬
 *
 *  두 개의 인접한 원소를 비교하여 정렬하는 방식
 *
 *  비교 정렬 / 제자리 정렬 (단 임시 변수 필요)
 *
 *  8, 3, 7, 5, 4, 2
 *
 *  3, 8, 7, 5, 4, 2
 *
 *  3, 7, 8, 5, 4, 2
 *
 *  3, 7, 5, 8, 4, 2
 *
 *  3, 7, 5, 4, 8, 2
 *
 *  3, 7, 5, 4, 2, 8 -> 3, 7, 5, 4, 2 (unsorted) | 8 (sorted)
 *
 *  .
 *  .
 *  .
 *
 *  3, 2, 4, 5, 7, 8 -> 3, 2 (unsorted) | 4, 5, 7, 8 (sorted)
 *  0  1  2  3  4  5 -> index
 *
 *  위 상황에서 3, 2 자리를 바꾸면 정렬 끝 -> last가 0 보다 커야 한다 조건인데, 1까지 내려왔을 때 (최소값인) 정렬이 끝남
 */
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
        // 배열 인덱스 <- 방향으로 정렬 (1번 인덱스까지 정렬하면, 나머지는 원소가 하나만 남으므로 더 이상 정렬 할 필요 없음)
        if (last > 0) {
            for (int i = 1; i <= last; i++) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i - 1, i);
                }
            }
            bubbleSort(arr, last - 1);
        }
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
