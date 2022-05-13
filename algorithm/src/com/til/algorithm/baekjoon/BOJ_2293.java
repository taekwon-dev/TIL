package com.til.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/13.
 * Title : 동전 1 (https://www.acmicpc.net/problem/2293)
 * Hint  : dp[0] = 1
 *         "여기서 dp[0]의 역할은 입력으로 들어온 동전 단 하나만으로 표현할 때 기본적으로 1 경우가 추가되는 의미다.
 *          10원짜리 동전으로 10원을 표현하면 단 한 가징 경우가 나오느 것과 같은 말이다"
 *
 *         동전 단위 별로 한 동전 단위로 k원을 표현할 수 있을 때를 고려해서  dp[0] = 1로 설정 (코드로 보면 이해 쉬움)
 *         https://www.youtube.com/watch?v=2IkdAk1Loek
 *
 */
public class BOJ_2293 {

    static int n, k;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        dp = new int[k + 1];

        dp[0] = 1;

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for (int j = arr[i]; j < k + 1; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }
        System.out.println(dp[k]);

    }
}
