package com.til.algorithm.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2752_SelectionSort {

    /**
     * 세수정렬
     *
     * 숫자 세 개 (오름차순) - 선택정렬, 버븗정렬
     */

    static int[] arr = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        selectionSort(0);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
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
