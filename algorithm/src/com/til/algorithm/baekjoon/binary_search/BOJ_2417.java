package com.til.algorithm.baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  정수 제곱근
 *
 *  정수가 주어지면, 그 수의 정수 제곱근을 구하는 프로그램을 작성하시오.
 *
 *  첫째 줄에 정수 n이 주어진다. (0 ≤ n < 2^63)
 *  첫째 줄에 q2 ≥ n인 가장 작은 음이 아닌 정수 q를 출력한다.
 *
 *  long타입의 정수 중 제곱했을 때 n보다 큰 값중 가장 작은 값을 찾는 문제.
 *
 *  n = 10
 *
 *  1, 2, 3, 4, 5, 6, 7, 8, 9, 10
 *  ↑           ↑               ↑
 *  (left)     (mid)           (right)
 *
 *  i) mid = 5
 *
 *  5^2 >= 10 이므로, 범위를 5보다 작은 범위에서 찾는다. (5보다 큰 범위에서는 수식을 만족하는데, 이 문제에서는 수식을 만족하는 가장 작은 수를 구해야 함)
 *  right = mid - 1
 *
 *  1, 2, 3, 4, 5
 *  ↑  ↑     ↑
 *
 *  left = 0 (index 기준)
 *  mid = 1 ((0 + 3) / 2)
 *  right = 3
 *
 *  ii) mid = 1
 *
 *  1^2 < 10
 *
 *  수식을 만족하지 않으므로, 수를 키운다.
 *
 *  left = mid + 1
 *
 *  2, 3, 4
 *  ↑  ↑  ↑
 *
 *  iii) mid = 3
 *
 *  3^2 < 10
 *
 *  수식을 만족하지 않으므로, 위 과정을 반복한다.
 *
 *  left = mid + 1
 *
 *  3, 4
 *  ↑  ↑
 *
 *  3^2 < 10
 *
 *  수식을 만족하지 않으므로, 위 과정을 반복한다.
 *
 *  left = mid + 1
 *
 *  iiii) mid = 4
 *
 *  4^2 >= 10
 *
 *  right = mid - 1
 *
 *  3, 4
 *  ↑  ↑
 *
 *  답 = 4
 *
 */
public class BOJ_2417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long left = 0, right = n;
        long min = Long.MAX_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;
            long pow = (long) Math.pow(mid, 2);

            if (pow >= 0) {
                if (pow >= n) {
                    min = Math.min(min, mid);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        System.out.println(min);
    }
}
