package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1182 {

    private static int n;
    private static int s;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        backtracking(nums, 0, 0);

        if (s == 0) {
            System.out.println(answer - 1);
            return;
        }
        System.out.println(answer);
    }

    private static void backtracking(List<Integer> nums, int depth, int sum) {
        if (depth == nums.size()) {
            if (sum > s) {
                return;
            }
            if (sum == s) {
                answer++;
            }
            return;
        }
        backtracking(nums, depth + 1, sum + nums.get(depth));
        backtracking(nums, depth + 1, sum);
    }
}
