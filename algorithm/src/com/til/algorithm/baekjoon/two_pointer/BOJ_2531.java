package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2531 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] sushi = new int[N];
        int[] number = new int[D + 1];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i = 0; i < K; i++) {
            if (number[sushi[i]] == 0) {
                cnt++;
            }
            number[sushi[i]]++;
        }
        int max = cnt;
        for (int i = 0; i < N; i++) {
            if (max <= cnt) {
                if (number[C] == 0) {
                    max = cnt + 1;
                } else {
                    max = cnt;
                }
            }
            if (number[sushi[i]] == 1) {
                cnt--;
            }
            number[sushi[i]]--;
            if (number[sushi[(i + K) % N]] == 0) {
                cnt++;
            }
            number[sushi[(i + K) % N]]++;
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
