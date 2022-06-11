package com.til.algorithm.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/11.
 * Title : 소가 길을 건너간 이유 1 (https://www.acmicpc.net/problem/14467)
 * Hint  :
 */
public class BOJ_14467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cows[] = new int[n + 1];
        int result = 0;
        Arrays.fill(cows, -1);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int place = Integer.parseInt(st.nextToken());

            if (cows[cow] == -1) {
                cows[cow] = place;
            }
            if (cows[cow] != -1 && cows[cow] != place) {
                result += 1;
                cows[cow] = place;
            }
        }
        System.out.println(result);
    }
}
