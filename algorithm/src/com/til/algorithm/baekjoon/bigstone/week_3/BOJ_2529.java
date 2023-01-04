package com.til.algorithm.baekjoon.bigstone.week_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2529 {

    private static int K;
    private static char[] sign;
    private static boolean[] visited = new boolean[10];
    private static List<String> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        K = Integer.parseInt(br.readLine());
        sign = new char[K];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int k = 0; k < K; k++) {
            sign[k] = st.nextToken().charAt(0);
        }

        backtracking(0, "");
        String max = Collections.max(nums);
        String min = Collections.min(nums);

        bw.write(max + "\n");
        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, String s) {
        if (depth == K + 1) {
            nums.add(s);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (depth == 0 || (!visited[i] && placeable(sign[depth - 1], s.charAt(s.length() - 1) - '0', i))) {
                visited[i] = true;
                backtracking(depth + 1, s + i);
                visited[i] = false;
            }
        }
    }

    private static boolean placeable(char sign, int former, int latter) {
        if (sign == '>') {
            return former > latter;
        }
        return former < latter;
    }
}