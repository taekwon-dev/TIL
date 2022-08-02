package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  넴모넴모 - 백트랙킹
 *
 *  1) 2차원 배열 맵에서 한 칸( 1 X 1 ) 착수 / ~ 착수
 *  2) 2 X 2 네모 칸이 있는지 검사
 *
 *  2 X 2 네모 칸이 없는 경우 게임이 종료 -> 게임이 종료되는 조건을 찾는 문제
 *
 *  1) 과정이 직관적으로 그려지지 않아서 이 과정을 출력하는 테스트 진행
 *
 */
public class BOJ_14712_TEST {
    static int n, m;
    static boolean[][] map;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];
        backtracking(0, 0);
        System.out.println(answer);
    }

    private static void backtracking(int row, int col) {
        print2DArr(map);
        if (row == n) {
            /** 2 X 2 맵 사이즈
             *  | -> -> | row = 0, col + 1 = m 일 때 한 줄 내려가기
             *  ↓ 내려가기
             *  | -> -> | row = 1, col + 1 = m 일 때 한 줄 내려가기
             *
             *  row = 2 이 때 검사를 한다는 뜻은 모든 칸에 착수 여부를 결정한 상태 (모든 칸에 대해서)
             *
             *  true true
             *  true true
             *
             *  true true
             *  true false
             *
             *  true true
             *  false true
             *
             *  true true
             *  false false
             *
             *  true false
             *  true true
             *
             *  true false
             *  true false
             *
             *  true false
             *  false true
             *
             *  true false
             *  false false
             *
             *  false true
             *  true true
             *
             *  false true
             *  true false
             *
             *  false true
             *  false true
             *
             *  false true
             *  false false
             *
             *  false false
             *  true true
             *
             *  false false
             *  true false
             *
             *  false false
             *  false true
             *
             *  false false
             *  false false
             *
             */
            // 네 칸씩 확인 (2 X 2)
            for (int i = 0; i <= n - 2; i++) {
                for (int j = 0; j <= m - 2; j++) {
                    if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                        return;
                    }
                }
            }
            answer++;
            return;
        }
        int nc = (col + 1 == m) ? 0 : col + 1;
        int nr = (nc == 0) ? row + 1 : row;

        map[row][col] = true;
        backtracking(nr, nc);
        map[row][col] = false;
        backtracking(nr, nc);
    }


    private static void print2DArr(boolean[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
