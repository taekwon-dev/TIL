package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2428 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] file = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            file[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(file);

        long answer = 0;
        int left = 0;
        int right = 0;
        while (left < N) {
            while (true) {
                if (right >= N - 1) {
                    break;
                }
                int l = file[left];
                int r = file[right + 1];
                if (l < r * 0.9) {
                    break;
                }
                right++;
            }
            answer += right - left;
            left++;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}