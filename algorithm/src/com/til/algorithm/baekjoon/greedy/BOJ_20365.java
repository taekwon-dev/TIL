package com.til.algorithm.baekjoon.greedy;

import java.io.*;

public class BOJ_20365 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] color = br.readLine().toCharArray();

        int blue = 0;
        int red = 0;

        for (int i = 0; i < N; i++) {
            if (color[i] == 'B') {
                blue++;
                while (i < N - 1) {
                    if (color[i] == color[i + 1]) {
                        i++;
                        continue;
                    }
                    break;
                }
            } else {
                red++;
                while (i < N - 1) {
                    if (color[i] == color[i + 1]) {
                        i++;
                        continue;
                    }
                    break;
                }
            }
        }
        int answer = 1 + Math.min(blue, red);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}