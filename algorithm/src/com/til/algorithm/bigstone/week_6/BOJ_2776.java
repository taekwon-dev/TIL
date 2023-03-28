package com.til.algorithm.bigstone.week_6;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2776 {

    private static int[] source;
    private static int[] target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int t = 0; t < TC; t++) {
            int N = Integer.parseInt(br.readLine());
            source = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                source[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(source);

            int M = Integer.parseInt(br.readLine());
            target = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                target[i] = Integer.parseInt(st.nextToken());
            }

            int[] answer = new int[target.length];
            for (int i = 0; i < target.length; i++) {
                answer[i] = binarySearch(target[i]);
            }

            StringBuilder sb = new StringBuilder();
            for (int number : answer) {
                sb.append(number).append("\n");
            }

            bw.write(sb.toString() + "\n");
            bw.flush();
        }

        bw.close();
        br.close();
    }

    private static int binarySearch(int targetNumber) {
        int left = 0;
        int mid = 0;
        int right = source.length - 1;

        while (left <= right) {
            mid = (left + right) / 2;
            if (targetNumber == source[mid]) {
                return 1;
            }
            if (targetNumber < source[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }
}