package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11256 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            int J = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int[] box = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int R = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                box[i] = R * C;
            }
            Arrays.sort(box);
            int answer = 1;
            int temp = J;
            for (int j = N - 1; j >= 0; j--) {
                if (box[j] >= temp) {
                    break;
                }
                temp -= box[j];
                answer++;
            }

            bw.write(answer + "\n");
            bw.flush();
        }

        bw.close();
        br.close();
    }
}