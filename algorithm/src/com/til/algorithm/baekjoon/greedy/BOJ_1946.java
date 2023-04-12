package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1946 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] score = new int[N][2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int paper = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                score[i][0] = paper;
                score[i][1] = interview;
            }
            Arrays.sort(score, Comparator.comparingInt(o -> o[0]));

            int answer = 1;
            int standard = score[0][1];
            for (int i = 1; i < N; i++) {
                if (score[i][1] < standard) {
                    answer++;
                    standard = score[i][1];
                }
            }

            bw.write(answer + "\n");
            bw.flush();
        }

        bw.close();
        br.close();
    }
}