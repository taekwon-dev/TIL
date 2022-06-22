package com.til.algorithm.baekjoon_naver_intern.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/18.
 * Title : 차이를 최대로 (https://www.acmicpc.net/problem/10819)
 * Hint  : |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
 *         정수의 순서를 적절히 바꿔서 위 식의 최댓값 찾기
 *         완전탐색 + 백트랙킹
 */
public class BOJ_10819 {
    static int n;
    static int max = Integer.MIN_VALUE;
    static int[] nums;
    static int[] results;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        results = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0);
        System.out.println(max);
    }

    private static void backtracking(int count) {
        if (count == n) {
            // 식의 값을 계산하고, 이 값이 최댓값인지 확인
            // 최댓값이면 최댓값을 업데이트하고, 아니면 버림.
            // 단, 이전에 판단 가능하면 아래 블록에서도 버리는 케이스 미리 확인하고 버릴 수 있음
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(results[i] - results[i + 1]);
            }
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                results[count] = nums[i];
                visited[i] = true;
                backtracking(count + 1);
                visited[i] = false;
            }
        }
    }

}
