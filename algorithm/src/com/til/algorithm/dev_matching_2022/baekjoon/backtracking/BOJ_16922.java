package com.til.algorithm.dev_matching_2022.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Youn on 2022/06/30.
 * Title : 로마 숫자 만들기 (https://www.acmicpc.net/problem/16922)
 * Hint  : 조합 (순서를 고려하지 않는다, 구성 요소가 같다면 같은 것으로 취급)
 *         중복조합 1, 5, 10, 50 각 수를 중복해서 선택할 수 있다 (예) 두 개의 문자를 선택한다고 했을 때 1(I) + 1(I) 이렇게 선택 가능
 */
public class BOJ_16922 {

    static int n;
    static int[] nums = {1, 5, 10, 50};
    static boolean[] visited = new boolean[1001]; // n 최댓값 20 -> 모두 50을 선택한 경우 = 1000
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        backtracking(0, 0, 0);
        System.out.println(result);
    }

    private static void backtracking(int depth, int index, int sum) {
        if (depth == n) {
            if (!visited[sum]) {
                visited[sum] = true;
                result += 1;
            }
            return;
        }
        for (int i = index; i < 4; i++) {
            backtracking(depth + 1, i, sum + nums[i]);
        }
    }

}
