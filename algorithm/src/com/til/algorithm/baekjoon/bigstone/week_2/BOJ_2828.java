package com.til.algorithm.baekjoon.bigstone.week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2828 {

    private static int n;
    private static int m;
    private static int j;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = left + m - 1;
        j = Integer.parseInt(br.readLine());

        for (int i = 0; i < j; i++) {
            int apple = Integer.parseInt(br.readLine());
            if (apple < left) {
                answer += (left - apple);
                left = apple;
                right = left + m - 1;
            }

            if (apple >= left && apple <= right) {
                answer += 0;
            }

            if (apple > right) {
                answer += (apple - right);
                right = apple;
                left = right - m + 1;
            }
        }
        System.out.println(answer);
    }
}