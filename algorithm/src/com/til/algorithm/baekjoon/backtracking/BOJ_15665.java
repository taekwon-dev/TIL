package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15665 {

    private static int n;
    private static int m;
    private static List<Integer> nums;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new ArrayList<>(n);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(nums);
        backtracking(0, "");
        System.out.println(sb.toString());
    }

    private static void backtracking(int depth, String s) {
        if (depth == m) {
            sb.append(s).append("\n");
            return;
        }

        int prev = 0;
        for (int i = 0; i < n; i++) {
            if (prev != nums.get(i)) {
                prev = nums.get(i);
                backtracking(depth + 1, s + nums.get(i) + " ");
            }
        }
    }
}
