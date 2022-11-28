package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10819 {

    private static int n;
    private static boolean[] visited;
    private static List<Integer> nums;
    private static List<Integer> permutation;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        nums = new ArrayList<>(n);
        permutation = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }
        backtracking(0);
        System.out.println(max);
    }

    private static void backtracking(int depth) {
        if (depth == n) {
            max = Math.max(max, calculate());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation.add(nums.get(i));
                backtracking(depth + 1);
                visited[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }

    private static int calculate() {
        int sum = 0;
        for (int i = 0; i < permutation.size() - 1; i++) {
            sum += Math.abs(permutation.get(i) - permutation.get(i + 1));
        }
        return sum;
    }
}