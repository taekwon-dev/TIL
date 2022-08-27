package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 1, 2, 3 더하기 2
 */
public class BOJ_12101 {
    static int n, k;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        backtracking(0, "");
        if (list.size() < k) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(k - 1));
        }
    }

    private static void backtracking(int sum, String str) {
        if (sum > n) return;
        if (sum == n) {
            list.add(str);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (sum == 0) {
                backtracking(sum + i, String.valueOf(i));
            } else {
                backtracking(sum + i, str + "+" + i);
            }
        }
    }

}
