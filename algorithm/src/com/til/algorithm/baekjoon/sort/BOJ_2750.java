package com.til.algorithm.baekjoon.sort;

import java.io.*;

public class BOJ_2750 {

    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        selectionSort(0);

        StringBuilder answer = new StringBuilder();
        for (int i : arr) {
            answer.append(i).append("\n");
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
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