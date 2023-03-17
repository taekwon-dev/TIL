package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_12101 {

    private static int N;
    private static int K;
    private static ArrayList<String> candidates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        candidates = new ArrayList<>();
        backtracking(0, "");
        Collections.sort(candidates);

        if (K > candidates.size()) {
            bw.write("-1" + "\n");
        } else {
            bw.write(candidates.get(K - 1));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int sum, String candidate) {
        if (sum > N) {
            return;
        }
        if (sum == N) {
            candidates.add(candidate.substring(0, candidate.length() - 1));
            return;
        }
        for (int i = 1; i <= 3; i++) {
            backtracking(sum + i, candidate + i + "+");
        }
    }
}