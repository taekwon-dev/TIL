package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  N과 M (8)
 *
 *  - 같은 수를 여러 번 골라도 된다. -> 각 노드(숫자)를 방문 여부를 기록할 필요 없음
 *  - 고른 수열은 비내림차순 -> 뒤에 있는 숫자가 (배열 인덱스 기준) 앞에 있는 숫자보다 같거나 커야 하므로 별도의 인덱스를 인자로 활용
 */
public class BOJ_15657 {
    static int n, m;
    static int[] arr;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        answer = new int[m];

        backtracking(0, 0);
        System.out.println(sb.toString());
    }

    private static void backtracking(int depth, int index) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(answer[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = index; i < n; i++) {
            answer[depth] = arr[i];
            backtracking(depth + 1, i);
        }
    }
}
