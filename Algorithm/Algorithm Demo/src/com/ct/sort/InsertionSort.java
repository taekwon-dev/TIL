package com.ct.sort;

public class InsertionSort {
    public static void main(String[] args) {
        // given
        int[] A = {45, 89, 67, 92, 53, 74, 26, 80};
        insertionSort(A);
        printArray(A);
    }

    private static void insertionSort(int[] A) {
        int i, j, insertElement;
        int n = A.length;

        for (i = 1; i < n; i++) {
            // 정렬이 안 된 요소 중 가장 첫번째 요소를 대상으로 초기화 (= 삽입 대상)
            insertElement = A[i];

            j = i - 1;
            // A[j] 값이 삽입 대상 값보다 클 때까지 반복
            while (j >= 0 && A[j] > insertElement) {
                A[j+1] = A[j];
                j = j-1;
                A[j+1] = insertElement;
            }
        }
    }

    private static void printArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }
}
