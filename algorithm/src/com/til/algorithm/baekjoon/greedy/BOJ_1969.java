package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1969 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] DNA = new String[N];
        int[] cnt = new int[4];

        for (int i = 0; i < N; i++) {
            DNA[i] = br.readLine();
        }

        int hd = 0;
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < M; i++) {
            Arrays.fill(cnt, 0);
            for (int j = 0; j < N; j++) {
                if (DNA[j].charAt(i) == 'A') {
                    cnt[0]++;
                } else if (DNA[j].charAt(i) == 'C') {
                    cnt[1]++;
                } else if (DNA[j].charAt(i) == 'G') {
                    cnt[2]++;
                } else {
                    cnt[3]++;
                }
            }
            int max = Math.max(cnt[0], Math.max(cnt[1], Math.max(cnt[2], cnt[3])));
            hd += N - max;

            if (max == cnt[0]) {
                answer.append('A');
            } else if (max == cnt[1]) {
                answer.append('C');
            } else if (max == cnt[2]) {
                answer.append('G');
            } else {
                answer.append('T');
            }
        }

        bw.write(answer.toString() + "\n");
        bw.write(hd + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
