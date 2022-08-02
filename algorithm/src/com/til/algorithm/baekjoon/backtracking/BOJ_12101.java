package com.til.algorithm.baekjoon.backtracking;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1, 2, 3 더하기 2
 *
 * 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다.
 * 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
 *
 * 1 + 1 + 1 + 1
 * 1 + 1 + 2
 * 1 + 2 + 1
 * 2 + 1 + 1
 * 2 + 2
 * 1 + 3
 * 3 + 1
 *
 * 1 <= N < 11
 *
 *
 * 자리수 기준 X
 * 합 기준이 N 이 되는 조건
 * 정수 n과 k가 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법 중에서 k번째로 오는 식을 구하는 프로그램을 작성하시오.
 *
 * 선택할 수 있는 수 [1, 2, 3]
 *
 * 근데, 한 개 이상을 선택해서 정수 N을 만들면 되기 때문에 일반적으로 백트랙킹 문제에서 자릿수가 정해진 것과 다른 부분이 있다.
 * 한 수를 여러 번 사용할 수 있다.
 *
 * 매번 선택할 떄마다 선택한 수의 합이 N이 되는 경우의 수를 구하고, 이 때 경우의 수 중 K번째로 오는 수식을 출력 (k번째 오는 식이 없는 경우에는 -1을 출력한다.)
 *
 * 합 조건을 만족할 때마다 ++ 연산을 통해서 K번째 도달하는 경우 출력
 *
 * 경우의 수 = K -> 마지막 경우의 수가 K인 경우
 * 경우의 수 > K -> 반드시 K 번째 수식이 있는 경우
 * 경우의 수 < K -> K 번째 수식이 없으므로 -1 출력
 */
public class BOJ_12101 {
    static int n, k, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        backtracking(0, "");
        if (cnt < k) System.out.println(-1);
    }

    private static void backtracking(int sum, String answer) {
        if (sum > n) return;
        if (sum == n) {
            // 선택한 수의 합이 N이 되는 경우
            // K 번째 수식을 찾기 위해 카운트한 뒤 K와 비교
            if (++cnt == k) {
                // K 번째 수식 출력
                // 마지막 수 뒤에 붙은 "+" 연산은 제거
                System.out.println(answer.substring(0, answer.length() - 1));
                System.exit(0);
            }
            return;
        }
        // i = 1, 2, 3
        for (int i = 1; i <= 3; i++) {
            backtracking(sum + i, answer + i + "+");
        }
    }
}
