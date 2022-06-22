package com.til.algorithm.baekjoon_naver_intern.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Youn on 2022/06/17.
 * Title : 좋은수열 (https://www.acmicpc.net/problem/2661)
 * Hint  : 규칟을 세우고 이를 식으로 나타내기 (차분하게), 순차적으로 적용 1 ~ 3 (가장 먼저 조건에 부합하는 경우가 정답)
 */
public class BOJ_2661 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        backtracking("");
    }

    private static void backtracking(String str) {
        if (str.length() == n) {
            System.out.println(str);
            System.exit(0);
        } else {
            for (int i = 1; i <= 3; i++) {
                if (good(str + i)) backtracking(str + i);
            }
        }
    }

    private static boolean good(String str) {
        for (int i = 1; i <= str.length() / 2; i++) {
            String front = str.substring(str.length() - i * 2, str.length() - i);
            String back = str.substring(str.length() - i, str.length());
            if (front.equals(back)) return false;
        }
        return true;
    }
}
