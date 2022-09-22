package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_6443 {
    static int n;
    static char[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String target = br.readLine();
            arr = target.toCharArray();
            Arrays.sort(arr);
            visited = new boolean[target.length()];
            backtracking(0, "");
        }
    }

    private static void backtracking(int depth, String s) {
        if (depth == arr.length) {
            System.out.println(s);
            return;
        }
        char prev = 'A';
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i] && prev != arr[i]) {
                visited[i] = true;
                prev = arr[i];
                backtracking(depth + 1, s + arr[i]);
                visited[i] = false;
            }
        }
    }
}
