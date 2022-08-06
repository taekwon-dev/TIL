package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  차이를 최대로
 *
 *  N 개의 정수로 이루어진 배열 A N (3 ≤ N ≤ 8) -> Brute force
 *  이 때 배열에 들어 있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하라
 *
 *  배열에 들어있는 정수는 -100보다 크거나 같고, 100보다 작거나 같다.
 *
 *  |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
 *
 *  예) 1, 2, 3
 *  | 1 - 2 | + | 2 - 3 | = 1 + 1 = 2
 *
 *  - 한 수를 여러번 사용할 수 없다.
 *  - 뽑은 숫자의 순서가 중요하다. -> 순열 {1, 2} vs {2, 1} = diff
 */
public class BOJ_10819 {
    static int n, max = 0;
    static int[] arr;
    static int[] rarr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        rarr = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0);
        System.out.println(max);
    }

    private static void backtracking(int depth) {
        if (depth == n) {
            // n - 1 개의 숫자를 모두 배치한 뒤
            // 수식 최댓값 계산
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(rarr[i] - rarr[i + 1]);
            }
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                rarr[depth] = arr[i];
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }

}
