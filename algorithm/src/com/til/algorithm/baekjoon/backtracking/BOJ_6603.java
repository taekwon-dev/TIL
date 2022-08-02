package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
 *
 *  K -> 에서 6개의 번호를 뽑는다. 첫 번째 수는 k (6 < k < 13)
 *  각 번호는 중복되지 않는다.
 *  한 번호를 여러 번 뽑을 수 없다.
 *  뽑은 수의 순서는 중요하지 않다 -> 조합 -> 같은 수를 뽑고 정렬하면 같은 부분집합이 된다.
 *
 *  사전 순으로 출력한다.
 *
 */
public class BOJ_6603 {
    static int k;
    static int[] s;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 0 이 아닐 때만 테스트 케이스 별로 로직 전개
        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) break;

            s = new int[k];
            p = new int[6];
            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }
            // 사전 순으로 출력하기 위해 오름차순 정렬
            Arrays.sort(s);
            backtracking(0, 0);
            System.out.println();
        }
    }

    private static void backtracking(int depth, int index) {
        // 6개의 번호를 뽑는 규칙
        if (depth == 6) {
            // 6개를 뽑고 나서 뽑은 번호 출력
            for (int i = 0; i < 6; i++) {
                System.out.print(p[i] + " ");
            }
            System.out.println();
            return;
        }
        // 부분집합 s에서 6개를 뽑는다.
        // 한 번호를 중복해서 뽑을 수 없다
        // 단 이 문제에서는 별도의 선택 여부로 상태 관리하지 않고, 인덱스 범위 조정으로 선택한 수를 뽑지 않도록 처리할 수 있다.
        for (int i = index; i < s.length; i++) {
            p[depth] = s[i];
            backtracking(depth + 1, i + 1);
        }
    }

}
