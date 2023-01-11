package com.til.algorithm.bigstone.week_2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17298_time_out {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        /**
         *  1 <= N <= 1,000,000 (백만)
         */
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    answer[i] = arr[j];
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}