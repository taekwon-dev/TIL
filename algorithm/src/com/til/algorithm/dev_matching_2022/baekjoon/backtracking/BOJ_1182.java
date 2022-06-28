package com.til.algorithm.dev_matching_2022.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/28.
 * Title : 부분수열의 합 (https://www.acmicpc.net/problem/1182)
 * Hint  : N 개의 정수로 구성된 수열, 해당 수열의 크기가 양수, 해당 수열의 모든 요소의 합이  가 되는 경우의 수
 */
public class BOJ_1182 {

    /**
     *  배열 -> 부분수열 :
     *  "부분수열을 구하는 방법으로 지금 위치의 원소를 택하는 방법과 선택하지 않는 방법이 있다"
     *  "합이 0인 경우 공집합도 포하되므로 그 수를 하나 빼주고 출력한다"
     *
     *
     *  각 부분수열의 합이 S가 되는 지 확인 (이 때 각 원소가 정수 - 음수 포함)
     *
     *  [-7, -3, -2, 5, 8]
     *
     *
     */
    static int n, s;
    static int[] nums;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0);
        if (s == 0) {
            // 0 인 경우, 공집합 케이스가 포함되는데 문제 조건에서 제외되므로 - 1 처리
            System.out.println(result - 1);
        } else {
            System.out.println(result);
        }
    }

    private static void backtracking(int depth, int sum) {
        if (depth == n) {
            if (sum == s) {
                result += 1;
            }
            return;
        }

        // 각 원소를 선택하는 경우 (부분수열 구성 시)
        backtracking(depth + 1, sum + nums[depth]);
        // 각 원소를 선택하지 않는 경우 (부분수열 구성 시)
        backtracking(depth + 1, sum);
    }


}
