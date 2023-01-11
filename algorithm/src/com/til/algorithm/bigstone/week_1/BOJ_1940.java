package com.til.algorithm.bigstone.week_1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1940 {

    private static int n;
    private static int m;
    private static int[] weapon;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        weapon = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weapon[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0, 0, 0);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int start, int sum) {
        if (depth == 2) {
            if (sum == m) {
                answer++;
            }
            return;
        }
        for (int i = start; i < weapon.length; i++) {
            backtracking(depth + 1, i + 1, sum + weapon[i]);
        }
    }
}