package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.util.Arrays.sort;

/**
 *  로또
 *
 *  독일 로또는 {1, 2, ..., 49}에서 수 6개를 고른다.
 *  가장 유명한 전략은 49가지 수 중 k(k>6)개의 수를 골라 집합 S를 만든 다음
 *  그 수만 가지고 번호를 선택하는 것이다.
 *
 *  k=8, S={1,2,3,5,8,13,21,34} -> 1 ~ 49 수 중 8개의 수를 뽑은 집합 (부분 집합 중 하나)
 *  S에서 수를 고를 수 있는 경우의 수는 총 28가지이다.
 *
 *  8C6 = 8C2 = 8 7 / 2 = 28
 *
 *
 *  집합 S와 k가 주어졌을 때, 수를 고르는 모든 방법
 */
public class BOJ_6603 {
    static int[] s;
    static int[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            s = new int[k];
            selected = new int[6];
            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }
            // 사전 순으로 경우의 수 출력하기 위해 정렬 (오름차순)
            sort(s);
            backtracking(0, 0);
            System.out.println();
        }
    }

    private static void backtracking(int depth, int index) {
        if (depth == 6) {
            // 6자리 숫자를 모두 고른 경우
            for (int i = 0; i < 6; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = index; i < s.length; i++) {
            selected[depth] = s[i];
            backtracking(depth + 1, i + 1);
        }
    }
}
