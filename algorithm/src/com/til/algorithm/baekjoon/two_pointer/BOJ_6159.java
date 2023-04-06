package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6159 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] cow = new int[N];

        for (int i = 0; i < N; i++) {
            cow[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(cow);

        int answer = 0;
        for (int i = 0; i < N - 1; i++) {
            int sum = cow[i];
            for (int j = i + 1; j < N; j++) {
                if (sum + cow[j] <= S) {
                    answer++;
                    continue;
                }
                break;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}