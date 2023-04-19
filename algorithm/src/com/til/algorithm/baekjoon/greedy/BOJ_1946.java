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
            int[][] rank = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                rank[i][0] = Integer.parseInt(st.nextToken());
                rank[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(rank, Comparator.comparingInt(o -> o[0]));

            int answer = 1;
            int interviewRank = rank[0][1];
            for (int i = 1; i < N; i++) {
                if (rank[i][1] > interviewRank) {
                    continue;
                }
                answer++;
                interviewRank = rank[i][1];
            }

            bw.write(answer + "\n");
            bw.flush();
        }

        bw.close();
        br.close();
    }
}