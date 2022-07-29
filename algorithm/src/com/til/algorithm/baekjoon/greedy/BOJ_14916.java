package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  거스름돈
 *
 *  손님이 2원짜리와 5원짜리로만 거스름돈을 달라고 한다.
 *  2원짜리 동전과 5원짜리 동전은 무한정 많이 가지고 있다.
 *  동전의 개수가 최소가 되도록 거슬러 주어야 한다.
 *
 *  거스름돈이 n인 경우, 최소 동전의 개수가 몇 개인지 알려주는 프로그램을 작성하시오.
 *  n(1 ≤ n ≤ 100,000)
 *
 *  예를 들어,
 *  거스름돈이 15원이면 5원짜리 3개를,
 *  거스름돈이 14원이면 5원짜리 2개와 2원짜리 2개로 총 4개를,
 *  거스름돈이 13원이면 5원짜리 1개와 2원짜리 4개로 총 5개를 주어야
 *  동전의 개수가 최소가 된다.
 *
 *  거스름돈 동전의 최소 개수를 출력한다. 만약 거슬러 줄 수 없으면 -1을 출력한다.
 *
 *  N을 2, 5 중 5를 기준으로 먼저 계산
 *
 *  13 / 5 = 2(몫) ... 3 (나머지)
 *  3 / 5 = 0(몫) -> 2를 기준으로 다시 계산
 *  3 / 2 = 1 ... 1 (나머지)
 *
 *  -> -1
 *  (n)
 *  13 / 5 = 1 ... 8 -> 2로 나눠진다. (= 2원을 기준으로 거스름 돈 줄 수 있음)
 *  8 / 5 = 1 ... 3 -> 2로 나눠지지 않으므로 (= 2원을 기준으로 거스름 돈 줄 수 없음) -> 패스
 *  8 / 2 = 4 ... 0 -> 나머지가 0 이므로 거스름돈 줄 수 있음
 *
 *  ->
 *
 *  5로 나누어 떨어지는 경우 -> 5로 나눈 몪을 카운트한다.
 *
 *  5로 나누어 떨어지지 않는 경우 -> 2를 뺀다. (2원을 사용한다)
 *
 */
public class BOJ_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        while (n > 0) {
            if (n % 5 == 0) {
                answer = n / 5 + answer;
                break;
            }
            n -= 2;
            answer++;
        }
        if (n < 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }

}
