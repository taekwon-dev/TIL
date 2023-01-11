package com.til.algorithm.bigstone.week_5;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  연속한 N개 이상의 수를 뽑는 경우의 수 = (N * N + 1) / 2
 */
public class BOJ_13144 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] checked = new boolean[N + 1];
        long answer = 0;
        for (int L = 1, R = 0; L <= N; L++) {
            while (R + 1 <= N && !checked[arr[R + 1]]) {
                R++;
                checked[arr[R]] = true;
            }
            answer += R - L + 1;
            checked[arr[L]] = false;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}