package com.til.algorithm.baekjoon.greedy;

import java.io.*;

public class BOJ_17615 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int rCnt = 0;
        int bCnt = 0;
        for (int i = 0; i < N; i++) {
            if (input.charAt(i) == 'R') {
                rCnt++;
            } else {
                bCnt++;
            }
        }
        int answer = N;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (input.charAt(i) == 'R') {
                cnt++;
                continue;
            }
            break;
        }
        answer = rCnt - cnt;

        cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (input.charAt(i) == 'R') {
                cnt++;
                continue;
            }
            break;
        }
        answer = Math.min(answer, rCnt - cnt);

        cnt = 0;
        for (int i = 0; i < N; i++) {
            if (input.charAt(i) == 'B') {
                cnt++;
                continue;
            }
            break;
        }
        answer = Math.min(answer, bCnt - cnt);

        cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (input.charAt(i) == 'B') {
                cnt++;
                continue;
            }
            break;
        }
        answer = Math.min(answer, bCnt - cnt);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}