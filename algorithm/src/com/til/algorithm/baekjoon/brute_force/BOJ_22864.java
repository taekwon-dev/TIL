package com.til.algorithm.baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22864 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (A > M) {
            System.out.println(0);
            return;
        }

        int workHours = 0;
        int fatigue = 0;

        for (int i = 0; i < 24; i++) {
            if (fatigue + A <= M) {
                workHours++;
                fatigue += A;
                continue;
            }
            fatigue -= C;
            if (fatigue < 0) {
                fatigue = 0;
            }
        }
        System.out.println(workHours * B);
    }
}
