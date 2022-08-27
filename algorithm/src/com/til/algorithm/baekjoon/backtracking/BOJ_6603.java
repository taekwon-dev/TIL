package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  로또
 *
 *  로또 -> 집합 -> 조합
 *
 */
public class BOJ_6603 {
    static int k;
    static int[] arr;
    static int[] tmp = new int[6];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            backtracking(0, 0);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void backtracking(int depth, int start) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(tmp[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < k; i++) {
            tmp[depth] = arr[i];
            backtracking(depth + 1, i + 1);
        }
    }

}
