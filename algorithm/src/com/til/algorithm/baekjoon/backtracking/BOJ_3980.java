package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  선발 명단
 *
 *  11명의 선수가 각각의 포지션에서의 능력을 0부터 100까지의 정수로 수치화 했다.
 *  0은 그 선수가 그 포지션에 적합하지 않다는 뜻이다.
 *
 *  이때, 모든 선수의 포지션을 정하는 프로그램을 작성하시오.
 *  모든 포지션에 선수를 배치해야 하고, 각 선수는 능력치가 0인 포지션에 배치될 수 없다.
 *
 *  입력은 여러 개의 테스트 케이스로 이루어져 있다. 첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
 *
 *  각각의 케이스는 11줄로 이루어져 있고,
 *  i번 줄은 0과 100사이의 11개의 정수 sij를 포함하고 있다.
 *
 *  sij는 i번선수가 j번 포지션에서 뛸 때의 능력이다.
 *  모든 선수에게 적합한 포지션의 수는 최대 5개이다. (능력치가 0보다 크다) -> 0보다 큰 수가 5개 이하 있다.
 *
 *  모든 포지션의 선수를 채웠을 때, 능력치의 합의 최댓값을 한 줄에 하나씩 출력한다
 *
 *  항상 하나 이상의 올바른 라인업을 만들 수 있다.
 *
 *
 *  - 해당 포지션에 대한 능력치가 0이면 해당 포지션에 설 수 없다.
 *
 *  - 내가 한 포지션 (= 열)을 잡으면 다른 인원은 해당 포지션에 설 수 없다.
 *    즉, A가 0번 포지션을 잡았을 때 B는 0번 포지션에 설 수 없다. (= 고를 수 없다)
 *
 *    11명의 선수가 11개의 포지션을 하나씩 점유
 *    즉, 한 명이 하나의 포지션에 일대일 대응되는 구조
 *
 *    능력치의 합의 최댓값
 */
public class BOJ_3980 {
    static int tc, max;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            max = 0;
            map = new int[11][11];
            visited = new boolean[11];
            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            backtracking(0, 0);
            System.out.println(max);
        }
    }

    private static void backtracking(int depth, int sum) {
        if (depth == 11) {
            // 능력 최댓값
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 11; i++) {
            if (!visited[i] && map[depth][i] != 0) {
                visited[i] = true;
                backtracking(depth + 1, sum + map[depth][i]);
                visited[i] = false;
            }
        }


    }

}
