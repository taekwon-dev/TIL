package com.til.algorithm.algorithm.sort;

/**
 *  시간 복잡도 : O(N log N)
 *
 *  0 - Indexed
 *  부모 노드 N
 *  왼쪽 자식 노드 N * 2 + 1
 *  오른쪽 자식 노드 N * 2 + 2
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {3, 10, 35, 23, 19, 47, 60, 35, 80, 44};
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }

    /**
     *
     */
    private static void heapSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int parent = getParent(arr.length - 1);

        for (int i = parent; i >= 0; i--) {
            heapify(arr, i, arr.length - 1);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i - 1);
        }
    }

    /**
     *  자식 노드 인덱스를 통해 해당 노드의 부모 노드 인덱스 반환
     */
    private static int getParent(int child) {
        return (child - 1) / 2;
    }

    private static void heapify(int[] arr, int parentIdx, int lastIdx) {
        int parent = parentIdx;
        int left = parentIdx * 2 + 1;
        int right = parentIdx * 2 + 2;

        if (left < lastIdx && arr[parent] < arr[left]) {
            parent = left;
        }

        if (right < lastIdx && arr[parent] < arr[right]) {
            parent = right;
        }

        if (parentIdx != parent) {
            swap(arr, parent, parentIdx);
            heapify(arr, parent, lastIdx);
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}