package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  좋은 수열
 *
 *  33 -> 3 중복
 *  32121323 -> 2121 중복
 *  123123213 -> 123123 중복
 *
 *  길이가 N인 좋은 수열들을 N자리의 정수로 보아 그중 가장 작은 수를 나타내는 수열을 구하는 프로그램을 작성하라.
 *  예를 들면, 1213121과 2123212는 모두 좋은 수열이지만 그 중에서 작은 수를 나타내는 수열은 1213121이다.
 *
 *  3 -> 다음 자리가 3이 아닌 경우
 *
 *  1 -> 2 -> 1 -> 여기서 2 를 고르면 나쁜 수열 (단 앞의 1, 2, 1 순서를 모두 알고 있어야 함)
 *
 *  N 칸씩 검사
 *  32121323 을 두 칸씩 검사
 *  32
 *  21 -> 중복
 *  12
 *  21 -> 중복
 *  32
 *  23
 *
 *  123123213 을 세 칸씩 검사
 *
 *  123 -> 중복
 *  231
 *  312
 *  123 -> 중복
 *  232
 *  321
 *  213
 *
 *  첫 번째 줄에 1, 2, 3으로만 이루어져 있는 길이가 N인 좋은 수열들 중에서 가장 작은 수를 나타내는 수열만 출력한다. 수열을 이루는 1, 2, 3들 사이에는 빈칸을 두지 않는다.
 *
 *  예)
 *  7자리를 만들먼서 가장 작은 수
 *
 *  근데, N 자리라고 했을 때 M 칸씩 검사할 때 반복이 가능한 M 의 최댓값?
 *
 *  예를 들어,
 *  M = 2 -> 1
 *  M = 3 -> 1
 *  M = 4 -> 2
 *  M = 5 -> 2
 *  M = 6 -> 3
 *  M = 7 -> 3
 *  M = 8 -> 4
 *
 *  M = N / 2 (최대)
 *
 *  따라서, M = 8 일 때는 최종적으로 4 칸 검사를 통과해야 함
 *  (이전에 1, 2, 3 칸 검사 통과한 전제)
 *
 *
 *
 */
public class BOJ_2661 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        backtracking("");
    }

    private static void backtracking(String num) {
        if (num.length() == n) {
            System.out.println(num);
            System.exit(0);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (good(num + i)) backtracking(num + i);
        }

    }

    public static boolean good(String str) {
        for(int i = 1; i <= str.length() / 2; i++) {
            
            String front = str.substring(str.length() - i * 2, str.length() - i);
            String back = str.substring(str.length() - i, str.length());
            if(front.equals(back)) return false;
        }
        return true;
    }
}
