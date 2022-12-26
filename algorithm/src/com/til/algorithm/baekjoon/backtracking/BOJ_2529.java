package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2529 {

    private static boolean[] visited = new boolean[10];
    private static int k;
    private static char[] sign;
    private static List<String> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        sign = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            sign[i] = st.nextToken().charAt(0);
        }
        backtracking(0, "");
        System.out.println(Collections.max(nums));
        System.out.println(Collections.min(nums));
    }

    private static void backtracking(int depth, String s) {
        if (depth == k + 1) {
            nums.add(s);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (depth == 0 || !visited[i] && isLocatable(sign[depth - 1], s.charAt(s.length() - 1) - '0', i)) {
                visited[i] = true;
                backtracking(depth + 1, s + i);
                visited[i] = false;
            }
        }
    }

    private static boolean isLocatable(char sign, int former, int latter) {
        if (sign == '>') {
            return former > latter;
        }
        return former < latter;
    }
}