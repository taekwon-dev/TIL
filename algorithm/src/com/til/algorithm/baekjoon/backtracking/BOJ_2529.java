package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2529 {

    private static int K;
    private static char[] sign;
    private static boolean[] visited;
    private static List<String> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        sign = new char[K];
        visited = new boolean[10];
        nums = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            sign[i] = st.nextToken().charAt(0);
        }
        backtracking(0, "");
        Collections.sort(nums);

        bw.write(nums.get(nums.size() - 1) + "\n");
        bw.write(nums.get(0) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, String num) {
        if (depth == K + 1) {
            nums.add(num);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (depth == 0 || !visited[i] && isLocatable(sign[depth - 1], num.charAt(num.length() - 1) - '0', i)) {
                visited[i] = true;
                backtracking(depth + 1, num + i);
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