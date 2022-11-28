package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_6603 {

    private static List<Integer> nums;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        while (true) {
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }
            nums = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                nums.add(Integer.parseInt(st.nextToken()));
            }
            backtracking(0, 0, "");
            System.out.println(sb.toString());
        }
    }

    private static void backtracking(int depth, int start, String s) {
        if (depth == 6) {
            sb.append(s).append("\n");
            return;
        }
        for (int i = start; i < nums.size(); i++) {
            backtracking(depth + 1, i + 1, s + nums.get(i) + " ");
        }
    }
}
