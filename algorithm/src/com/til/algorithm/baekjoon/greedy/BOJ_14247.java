package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_14247 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        StringTokenizer tree = new StringTokenizer(br.readLine());
        StringTokenizer grow = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(tree.nextToken());
            arr[i][1] = Integer.parseInt(grow.nextToken());
        }
        Arrays.sort(arr, Comparator.comparingInt(t -> t[1]));

        long answer = 0;
        for (int i = 0; i < N; i++) {
            answer += arr[i][0] + arr[i][1] * i;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}