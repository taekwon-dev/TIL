package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  블랙잭
 *
 *  N장의 카드를 고른 뒤 N장의 카드에 적힌 숫자의 합이 M을 넘기지 않으면서 M과 최대한 가깝게 만들어야 한다.
 *  N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.
 *  N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)
 *  합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.
 *
 *  - 같은 수를 여러번 고를 수 없다.
 *  - 뽑은 카드의 순서가 중요하지 않다 (-> 조합)
 */
public class BOJ_2798 {
    static int n, m, max = 0;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0, 0);
        System.out.println(max);
    }

    private static void backtracking(int depth, int sum) {
        if (sum > m) return;
        if (depth == 3) {
            // 3장의 코드를 골랐다.
            // 3장의 카드합 (<= M) 최댓값
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(depth + 1, sum + arr[i]);
                visited[i] = false;
            }
        }
    }
}
