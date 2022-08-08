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
 *  S = 10
 *
 *  1 2 3 4 5 6 7 8 9 10
 *  ↑       ↑          ↑
 *
 *  mid pointer 조정하면서 범위 지정
 *
 *  1 + 2 + 3 + 4 + 5 = 15 (> S) 이므로, 왼쪽 범위에서 다시 범위 설정 (기본적으로 N 을 크게 가지고 가려면 작은 수를 더해야 함)
 *
 *  right = mid - 1
 *  1 2 3 4
 *  ↑ ↑   ↑
 *
 *  left = 1 (index 0)
 *  mid = 2 (index 1)
 *  right = 4 (index 3)
 *
 *  1 + 2 = 3 (< S) 이므로 더 큰 범위
 *
 *  이 경우 mid 를 한 칸 옮기기만 하자.
 *
 *  mid = mid + 1
 *
 *  1 + 2 + 3 = 6 (< S)
 *
 *  mid = mid + 1
 *
 *  1 + 2 + 3 + 4 = 10 (= S)
 *
 *  이 때 mid = 4 (index 3)
 */
public class BOJ_1789 {
    static long s;
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Long.parseLong(br.readLine());
        binarySearch(1, s);
        System.out.println(answer);
    }

    private static void binarySearch(long start, long end) {
        if (start > end) {
            return;
        }
        long mid = (start + end) / 2;
        long sum = calSum(mid);

        if (sum > s) {
            binarySearch(start, mid - 1);
        } else if (sum < s) {
            binarySearch(mid + 1, end);
        } else {
            answer = mid;
            return;
        }
    }

    // 1 ~ x 까지의 합
    // 등차수열의 합 공식
    private static long calSum(long x) {
        return (x * (x + 1)) / 2;
    }
}
