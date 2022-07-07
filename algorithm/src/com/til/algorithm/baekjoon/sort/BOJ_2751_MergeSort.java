package com.til.algorithm.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  시간초과
 */

public class BOJ_2751_MergeSort {

    static int n;
    static int[] arr;
    static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        sorted = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(0, arr.length - 1);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            mergeSort(start, mid);
            mergeSort(mid + 1, end);

            merge(start, mid, end);
        }
    }

    private static void merge(int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            sorted[i] = arr[i];
        }

        int left = start;
        int right = mid + 1;
        int index = start;

        while (left <= mid && right <= end) {
            if (sorted[left] <= sorted[right]) {
                arr[index] = sorted[left];
                left++;
            } else {
                arr[index] = sorted[right];
                right++;
            }
            index++;
        }

        for (int i = 0; i <= mid - left; i++) {
            arr[index + i] = sorted[left + i];
        }

    }



}
