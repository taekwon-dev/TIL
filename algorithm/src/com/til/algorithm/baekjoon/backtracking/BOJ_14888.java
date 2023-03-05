package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14888 {

    private static int N;
    private static int[] arr;
    private static int[] operators;
    private static int min;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        operators = new int[4];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operators.length; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }
        // 연산자와 연산 대상 숫자의 관계를 고려해서 시작 값을 첫 번째 숫자로 지정
        backtracking(0, arr[0]);

        bw.write(max + "\n");
        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int sum) {
        if (depth == N - 1) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < operators.length; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                if (i == 0) {
                    backtracking(depth + 1, sum + arr[depth + 1]);
                } else if (i == 1) {
                    backtracking(depth + 1, sum - arr[depth + 1]);
                } else if (i == 2) {
                    backtracking(depth + 1, sum * arr[depth + 1]);
                } else if (i == 3) {
                    backtracking(depth + 1, sum / arr[depth + 1]);
                }
                operators[i]++;
            }
        }
    }
}