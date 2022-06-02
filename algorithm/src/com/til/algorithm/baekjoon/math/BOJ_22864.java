package com.til.algorithm.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/02.
 * Title : 피로도 (https://www.acmicpc.net/problem/22864)
 * Hint  :
 */
public class BOJ_22864 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int hour = 0, p = 0, answer = 0;
        while (hour != 24) {
            if (p + a <= m) {
                answer += b;
                p += a;
            } else {
                p = p - c < 0 ? 0 : p - c;
            }
            hour++;
        }
        System.out.println(answer);
    }

}
