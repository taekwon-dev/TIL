package com.til.algorithm.bigstone.week_5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1911 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] waters = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            waters[i][0] = start;
            waters[i][1] = end;
        }
        Arrays.sort(waters, (w1, w2) -> {
            if (w1[0] == w2[0]) {
                return w1[1] - w2[1];
            }
            return w1[0] - w2[0];
        });

        int answer = 0;
        int cover = 0;

        for (int i = 0; i < N; i++) {
            if (waters[i][0] > cover) {
                cover = waters[i][0];
            }
            while (waters[i][1] > cover) {
                cover += L;
                answer++;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}