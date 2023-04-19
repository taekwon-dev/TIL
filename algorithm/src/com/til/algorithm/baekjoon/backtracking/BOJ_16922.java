package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.HashSet;

public class BOJ_16922 {

    private static int N;
    private static int[] arr = {1, 5, 10, 50};
    private static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        backtracking(0, 0, 0);

        bw.write(set.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int index, int sum) {
        if (depth == N) {
            set.add(sum);
            return;
        }
        for (int i = index; i < arr.length; i++) {
            backtracking(depth + 1, i, sum + arr[i]);
        }
    }
}