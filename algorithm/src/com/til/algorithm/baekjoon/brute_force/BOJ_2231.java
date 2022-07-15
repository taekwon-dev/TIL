package com.til.algorithm.baekjoon.brute_force;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  분해합
 *
 *  자연수 N
 *
 *  N의 분해합 = N과 N을 이루는 각 자리수의 합
 *
 *  245 = 245 + 2 + 4 + 5 -> 256 (245 의 생성자)
 *
 *  생성자가 없는 경우도 있고, 생성자가 여러 개인 자연수도 있을 수 있다.
 *  자연수 N(1 ≤ N ≤ 1,000,000)에 대해서 가장 작은 생성자를 구해라.
 *
 *  245 + 2 + 4 + 5 = 256
 *
 *  1의 생성자는? 없음
 *  ....  = 1 -> 자연수 범위에서 없음
 *
 *  2의 생성자는 ?
 *  ....  = 2 -> 생성자 1
 *  1 + 1 = 2
 *
 *  3의 생성자는 ?
 *
 *  ....  = 3 -> 자연수 범위에서 없음
 *
 *  1 + 1 = 2
 *  2 + 2 = 4
 *  3 + 3 = 6
 *
 *  .
 *  .
 *  .
 *  10의 생성자는 ? -> 생성자 5
 *  5 + 5 = 10
 *
 *  N + .. = M
 *
 *  M이 주어졌을 때 N을 찾아야 한다. 그리고 N이 여러개인 경우 가장 작은 수를 출력, 없는 경우 0 출력
 *
 *  N + 각 자리수 합 = M 을 만족하는 N을 찾아야 한다.
 */
public class BOJ_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0; // 못 찾은 경우 0 이므로, 0으로 초기화

        for (int i = 1; i < n; i++) {
            int target = i;
            int sum = 0;
            while (target != 0) {
                sum += target % 10; // 1의 자리수부터 나머지 구하기를 통해 자리 수 더한다.
                target /= 10; // 몪 구하기 통해 그 다음 자리수로 이동 (몫이 0이 되는 경우 더 이상 더할 자리수가 없음)
            }
            if (i + sum == n) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }

}
