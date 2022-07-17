package com.til.algorithm.baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  수들의 합
 *
 *  서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때,
 *
 *  자연수 N의 최댓값은 얼마일까? = 최대한 많은 수로 구성하기
 *
 *  예를 들어,
 *
 *  S = 100
 *
 *  100 (1)
 *
 *  1 + 99 (2)
 *
 *  1 + 2 + 97 (3)
 *
 *  1 + 2 + 3 + 94 (4)
 *
 *  1 + 2 + 3 + 4 + 90 (5)
 *
 *  1 + 2 + 3 + 4 + 5 + 85 (6)
 *
 *
 *  첫째 줄에 자연수 S(1 ≤ S ≤ 4,294,967,295)가 주어진다.
 *
 *  Java (signed) int (4byte) : -2,147,483,648 ~ 2,147,483,647
 *
 *  Java 에서는 unsigned int 를 지원하지 않는다.
 *
 *  2,147,483,648
 *  2,147,483,647
 *  -------------
 *  4,294,967,295 (long)
 *
 *  N = 자연수 범위이므로,
 *  가장 많은 수로 S 를 구성하기 위해서는 작은 수 부터 구성해야 한다.
 *
 *  예를 들어, S = 55
 *  1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55
 */
public class BOJ_1789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());

        long sum = 0;
        long count = 0;
        long num = 1;


        while (sum < s) {
            // sum > s (N 개의 수 합이 s 를 초과하는 시점에 break)
            sum += num;
            num++;
            count++;
        }
        // sum 이 s 를 초과한 시점에 break 됐으므로,
        // count - 1 을 출력한다.
        System.out.println(count - 1);
    }
}
