package com.ct.sort;

public class SelectionSort {
    public static void main(String[] args) {
        int [] intArray = {12, 14, 35, 1, 23, 66, 76, 6};

        selectionSort_R(intArray); // 재귀
//        selectionSort(intArray);

        // 1 6 12 14 23 35 66 76
        printArray(intArray);

    }


    private static void selectionSort(int[] A) {
        int i, j, min, temp;
        int n = A.length;

        for (i = 0; i < n-1; i++) {
            min = i;
            for (j = i+1; j < n; j++) {
                if (A[j] < A[min]) {
                    // 최솟값이 어떤 인덱스에 위치했는 지 파악
                    min = j;
                }
            }
            // temp <- 최솟값 임시 저장
            temp = A[min];
            A[min] = A[i];
            A[i] = temp;
        }
    }

    private static void printArray(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
        System.out.println();
    }

    private static void selectionSort_R(int[] arr) {
        selectionSort(arr, 0);
    }

    private static void selectionSort(int[] arr, int start) {
        if (start < arr.length-1) {
            int min_index = start;
            for (int i = start; i < arr.length; i++) {
                if (arr[i] < arr[min_index]) min_index = i;
            }
            swap(arr, start, min_index);
            selectionSort(arr, start+1);
        }
    }


    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}


