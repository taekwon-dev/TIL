package com.til.algorithm.bigstone.week_6;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14627 {

    private static int S;
    private static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int[] pa = new int[S];

        long sum = 0;
        for (int i = 0; i < S; i++) {
            pa[i] = Integer.parseInt(br.readLine());
            sum += pa[i];
        }
        int left = 1;
        int right = 1_000_000_000;

        while (left <= right) {
            int mid = (left + right) / 2;
            int order = 0;
            for (int p : pa) {
                order += p / mid;
            }
            if (order >= C) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        long answer = sum - right * (long) C;

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}