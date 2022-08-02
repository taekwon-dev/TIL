package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  부분집합 -> 선택 / 미선택
 *  (1 ≤ N ≤ 20, |S| ≤ 1,000,000)
 *
 *  부분집합 구성 과정
 *
 *  예) {1, 2, 3}
 *
 *  2^3 : 각 원소를 선택 또는 미선택 (총 8가지)
 *
 *  공집합 -> 선택 : 없음 미선택 : 1, 2, 3
 *
 *  {1} -> 선택 : 1 미선택 :  2, 3
 *  {2} -> 선택 : 2 미선택 :  1, 3
 *  {3} -> 선택 : 3 미선택 :  1, 2
 *
 *  {1, 2} -> 선택 : 1, 2 미선택 :  3
 *  {1, 3} -> 선택 : 1, 3 미선택 :  2
 *  {2, 3} -> 선택 : 2, 3 미선택 :  1
 *
 *  {1, 2, 3} -> 선택 : 1, 2, 3 미선택 :  없음
 *
 *
 *
 *
 */
public class BOJ_1182_TEST {
    static int n, s, answer;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0, 0);

    }

    private static void backtracking(int depth, int sum) {
        if (depth == n) {
            printArr(visited);
            if (sum == s) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            visited[depth] = true;
            backtracking(depth + 1, sum + arr[depth]); // 해당 원소 선택
            visited[depth] = false;
            backtracking(depth + 1, sum); // 미선택
        }
    }

    private static void printArr(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
