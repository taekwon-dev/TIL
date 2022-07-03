package com.til.algorithm.이코테.ch6_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/13.
 * Title : 효율적인 화폐 구성 (https://www.youtube.com/watch?v=5Lu34WIx2Us)
 * Hint  : 각 화폐 단위 별로 접근 (보유한 화폐 단위를 동시에 고려할 수 없음)
 *         1 <= n <= 100, 1 <= M <= 10,000
 *         INF (양의 무한대) 값으로 10,001로 설정
 *
 *         a𝖎 = 금액 𝖎를 만들 수 있는 최소한의 화폐 개수
 *         k = 각 화폐의 단위
 *
 *         a𝖎-k를 만드는 방법이 존재하면, a𝖎 = min(a𝖎, a𝖎-k + 1)
 *         a𝖎-k를 만드는 방법이 존재하지 않는 경우, a𝖎 = INF
 */
public class 효율적인화폐구성 {

    static int n, m;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 동전 가지 수
        m = Integer.parseInt(st.nextToken()); // 타켓

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[m + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++) {
                if (dp[j - arr[i]] != 10001) {
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                }
            }
        }
        if (dp[m] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[m]);
        }
    }
}
