package com.til.algorithm.baekjoon.greedy;

import java.io.*;

public class BOJ_20365 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] c = br.readLine().toCharArray();
        int b = 0;
        int r = 0;

        for (int i = 0; i < N; i++) {
            if (c[i] == 'B') {
                b++;
                while (i < N - 1) {
                    if (c[i] != c[i + 1]) {
                        break;
                    }
                    i++;
                }
            } else {
                r++;
                while (i < N - 1) {
                    if (c[i] != c[i + 1]) {
                        break;
                    }
                    i++;
                }
            }
        }
        int answer = Math.min(b, r) + 1;

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}