package com.til.algorithm.baekjoon_pack_mg.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/26.
 * Title : N과 M (3) (https://www.acmicpc.net/problem/15651)
 * Hint  : 같은 수를 여러 번 고를 수 있다. (시간 초과 - StringBuilder 사용 후 통과)
 */
public class BOJ_15651 {
    static int n, m;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[m];

        backtracking(0);
    }

    private static void backtracking(int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                sb.append(nums[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            nums[count] = i;
            backtracking(count + 1);
        }
    }
}
