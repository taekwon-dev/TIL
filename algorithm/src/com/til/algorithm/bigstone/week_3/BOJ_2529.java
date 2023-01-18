package com.til.algorithm.bigstone.week_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2529 {

    private static int K;
    private static char[] signs;
    private static boolean[] used = new boolean[10];
    private static ArrayList<String> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        K = Integer.parseInt(br.readLine());
        signs = new char[K];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            signs[i] = st.nextToken().charAt(0);
        }

        backtracking(0, "");
        bw.write(Collections.max(nums) + "\n");
        bw.write(Collections.min(nums) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, String sum) {
        if (depth == K + 1) {
            // K개의 부등호 = K + 1개의 수
            nums.add(sum);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (depth == 0 || !used[i] && isLocatable(signs[depth - 1], sum.charAt(sum.length() - 1) - '0', i)) {
                used[i] = true;
                backtracking(depth + 1, sum + i);
                used[i] = false;
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