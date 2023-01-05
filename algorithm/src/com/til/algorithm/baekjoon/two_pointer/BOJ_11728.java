package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arrN = new int[N];
        int[] arrM = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrM);

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < N && j < M) {
            if (arrN[i] < arrM[j]) {
                sb.append(arrN[i++]).append(" ");
                continue;
            }
            sb.append(arrM[j++]).append(" ");
        }

        while (i < N) {
            sb.append(arrN[i++]).append(" ");
        }

        while (j < M) {
            sb.append(arrM[j++]).append(" ");
        }
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}