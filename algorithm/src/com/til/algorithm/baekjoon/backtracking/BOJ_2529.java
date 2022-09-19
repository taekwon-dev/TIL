package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2529 {
    static int k;
    static char[] arr;
    static boolean[] visited;
    static ArrayList<String> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr = new char[k];
        visited = new boolean[9 + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        backtracking(0, "");
        Collections.sort(nums);
        System.out.println(nums.get(nums.size() - 1));
        System.out.println(nums.get(0));
    }

    private static void backtracking(int depth, String num) {
        if (depth == k + 1) {
            nums.add(num);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (depth == 0 || !visited[i] && compare(arr[depth - 1], num.charAt(num.length() - 1) - '0', i)) {
                visited[i] = true;
                backtracking(depth + 1, num + i);
                visited[i] = false;
            }
        }
    }

    private static boolean compare(char sign, int x, int y) {
        if (sign == '<') {
            return x < y;
        } else {
            return x > y;
        }
    }
}
