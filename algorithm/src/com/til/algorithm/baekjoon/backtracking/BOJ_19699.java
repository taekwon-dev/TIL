package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_19699 {
    static int n, m;
    static int[] weight;
    static Set<Integer> selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        weight = new int[n];
        visited = new boolean[n];
        selected = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0);
        ArrayList<Integer> answer = new ArrayList<>(selected);
        Collections.sort(answer);
        if (answer.size() == 0) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < answer.size(); i++) {
                System.out.print(answer.get(i) + " ");
            }
        }
    }

    private static void backtracking(int depth, int sum) {
        if (depth == m) {
            // 소수 판별 후
            // 소수인 경우 선별 리스트 추가
            if (prime(sum)) selected.add(sum);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(depth + 1, sum + weight[i]);
                visited[i] = false;
            }
        }
    }

    private static boolean prime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
