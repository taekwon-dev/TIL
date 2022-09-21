package com.til.algorithm.baekjoon.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 귀찮아 (SIB)
 * <p>
 * N = 3
 * [1, -2, 3]
 * <p>
 * [1, -1, 2]
 * <p>
 * 1 <= a < b <= 3
 * <p>
 * a = 1, b = 2
 * a = 1, b = 3
 * <p>
 * a = 2, b = 3
 * <p>
 * <p>
 * <p>
 * -2 + 3 + -6 = -5
 * <p>
 * 1 + 2
 * 1 + 3
 * 2 + 3
 * <p>
 * a1b2 + a1b3 + ... -> a1(b2 + b3 + ...)
 * a2b3 + a2b4 + ... -> a2(b3 + b4 + ...)
 * a3b4 + a3b5 + ... -> a3(b4 + b5 + ...)
 * an-1bn
 * <p>
 * long sum = 0;
 * for (int i = 1; i <= n; i++) {
 * for (int j = i + 1; j <= n; j++) {
 * // 연산 -> 시간 초과
 * }
 * }
 * <p>
 * https://velog.io/@boorook/Python-%EB%B0%B1%EC%A4%80-14929-%EA%B7%80%EC%B0%AE%EC%95%84-SIB-%EB%AC%B8%EC%A0%9C-%ED%92%80%EC%9D%B4
 */
public class BOJ_14929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }
        long answer = 0;
        for (int i = 1; i < n; i++) {
            answer += sum[i] * arr[i + 1];
        }
        System.out.println(answer);
    }
}
