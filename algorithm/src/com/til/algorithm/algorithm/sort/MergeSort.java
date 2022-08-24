package com.til.algorithm.algorithm.sort;

/**
 *  분할 정복
 *
 *  비교 정렬
 *  ~ 제자리 정렬 -> 추가 공간 필요
 *  안정 정렬
 *
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 7, 8, 6};
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }

    private static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid + 1, end);

            // 나누고 나서 병합
            merge(arr, tmp, start, mid, end);
        }
    }

    private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        System.out.println(start + " ~ " + mid + " ~ " + end);
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;

        while (part1 <= mid && part2 <= end) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }

        // Part1에 남은 경우
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
