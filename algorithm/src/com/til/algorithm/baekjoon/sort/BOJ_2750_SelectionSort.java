package com.til.algorithm.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2750_SelectionSort {

    /**
     * 수 정렬하기
     * <p>
     * N 개의 수를 오름차순으로 정렬하기 (최대 1000개)
     * <p>
     * O(N^2) = 1000 * 1000 = 1,000,000 (백만) 1초 안에 해결 가능 문제
     * - 선택정렬
     * - 버블정렬
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
        selectionSort(0);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void selectionSort(int start) {
        if (start < arr.length - 1) {
            int minIndex = start;
            for (int i = start; i < arr.length; i++) {
                if (arr[i] < arr[minIndex]) minIndex = i;
            }
            int tmp = arr[start];
            arr[start] = arr[minIndex];
            arr[minIndex] = tmp;
            selectionSort(start + 1);
        }
    }
}
