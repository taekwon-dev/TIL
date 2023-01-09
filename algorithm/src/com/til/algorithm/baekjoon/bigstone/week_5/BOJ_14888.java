package com.til.algorithm.baekjoon.bigstone.week_5;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14888 {

    private static int N;
    private static int[] nums;
    private static int[] ops;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        ops = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < ops.length; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0, nums[0]);
        bw.write(max + "\n");
        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int result) {
        if (depth == N - 1) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        for (int i = 0; i < ops.length; i++) {
            if (ops[i] > 0) {
                ops[i]--;
                if (i == 0) {
                    backtracking(depth + 1, result + nums[depth + 1]);
                } else if (i == 1) {
                    backtracking(depth + 1, result - nums[depth + 1]);
                } else if (i == 2) {
                    backtracking(depth + 1, result * nums[depth + 1]);
                } else if (i == 3) {
                    backtracking(depth + 1, result / nums[depth + 1]);
                }
                ops[i]++;
            }
        }
    }
}