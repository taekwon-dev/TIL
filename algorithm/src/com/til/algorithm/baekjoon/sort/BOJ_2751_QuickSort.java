package com.til.algorithm.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2751_QuickSort {

    /**
     * N 개의 수 오름차순으로 정렬 (N 최대 1,000,000)
     *
     * O(N^2) = 1,000,000 * 1,000,000 = 1,000,000,000,000
     *
     * 1초 100,000,000 기준으로 생각하면, 2초가 주어져도 처리할 수 없는 범위
     *
     * O(N log N)
     * - Quick Sort (최악의 경우 O(N^2) -> 테스트 케이스에서 최악의 경우가 포함된 경우 -> 시간 초과)
     */
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        quickSort(0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void quickSort(int start, int end) {
        if (start >= end) return;
        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && arr[left] <= arr[pivot]) left++;
            while (right > start && arr[right] >= arr[pivot]) right--;

            if (left > right) {
                int tmp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = tmp;
            } else {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        quickSort(start, right - 1);
        quickSort(right + 1, end);
    }
}
