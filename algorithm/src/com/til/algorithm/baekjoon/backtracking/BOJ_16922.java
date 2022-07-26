package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  로마 숫자 만들기
 *
 *  I, V, X, L
 *  1, 5, 10, 50
 *
 *  하나 또는 그 이상의 문자를 이용해서 수를 나타낼 수 있다
 *  문자열이 나타내는 값은, 각 문자가 의미하는 수를 모두 합한 값이다.
 *  예를 들어, XXXV는 35, IXI는 12를 의미한다.
 *
 *  실제 로마 숫자에서는 문자의 순서가 중요하지만,
 *  이 문제에서는 순서는 신경쓰지 않는다.
 *
 *  로마 숫자를 N개 사용해서 만들 수 있는
 *  서로 다른 수의 개수를 구해보자.
 *
 *  N (1 ≤ N ≤ 20)
 *
 *  예)
 *
 *  N = 1
 *
 *  4C1 = 4
 *
 *  N = 2
 *
 *  4C2 (X) - 서로 다른 수를 골라야 함. 다시 말해 조합된 문자로 만든 수가 같으면 하나로 친다.
 *
 *  II
 *  IV
 *  IX
 *  IL
 *  VV
 *  VX
 *  VL
 *  XX
 *  XL
 *  LL
 *
 *  총 10개
 *
 *  따라서 문제 조건을 정리하면,
 *  - 같은 수를 여러 번 (= 최대 주어진 문자 수 만큼) 고를 수 있다.
 *  - 비내림차순
 *
 *  테스트 결과
 *
 *  위 조건만으로 했을 때 조합된 결과가 중복되는 케이스가 있으므로,
 *  조합 - 조합된 결과가 중복되는 케이스 = 정답
 *  따라서, 합이 같은 것이 여러개 있는 경우 1개로 치기 위한 작업 필요
 */
public class BOJ_16922 {
    static int n, answer;
    static int[] arr = {1, 5, 10, 50};
    static boolean[] visited;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        visited = new boolean[1000 + 1];

        backtracking(0, 0, 0);
        System.out.println(answer);
    }

    private static void backtracking(int depth, int index, int sum) {
        if (depth == n) {
            if (!visited[sum]) {
                answer++;
                visited[sum] = true;
            }
            return;
        }
        for (int i = index; i < 4; i++) {
            backtracking(depth + 1, i, sum + arr[i]);
        }
    }

}
