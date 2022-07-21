package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  N과 M (9)
 *
 *  N개의 자연수는 모든 다른 수가 아닐 수 있다. (-> 중복된 수가 있을 수 있다)
 *
 *  3 1
 *  4 4 2
 *
 *  4
 *  4 -> 중복 ( -> 중복되는 수열은 여러 번 출력하지 않는다)
 *  2
 *
 *  prev 상태를 추가로 저장해서 이전 값과 같으면 출력하지 않고 continue 한다.
 *
 *  4 -> prev
 *  4 -> prev vs curr -> continue (passing)
 *  2
 *
 */
public class BOJ_15663 {
    static int n, m;
    static int[] arr;
    static int[] answer;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        answer = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backtracking(0);
        System.out.println(sb.toString());
    }

    private static void backtracking(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(answer[i] + " ");
            }
            sb.append("\n");
            return;
        }
        // arr 내 원소는 모두 자연수 범위 -> 따라서 0으로 초기화
        int prev = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (prev != arr[i]) {
                    prev = arr[i];
                    visited[i] = true;
                    answer[depth] = arr[i];
                    backtracking(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
