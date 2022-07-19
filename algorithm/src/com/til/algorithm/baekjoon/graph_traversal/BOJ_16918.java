package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  봄버맨
 *
 *  시뮬레이션, 구현, 그래프 탐색
 *
 *  R * C 격자칸, 격자의 각 칸은 비어있거나 폭탄이 들어있다.
 *
 *  폭탄이 있는 칸은 3초가 지난 후에 폭발하고,
 *  폭탄이 폭발한 이후에는 폭탄이 있던 칸이 파괴되어 빈 칸이 되며, 인접한 네 칸도 함께 파괴된다.
 *  만약, 폭탄이 폭발했을 때, 인접한 칸에 폭탄이 있는 경우에는 인접한 폭탄은 폭발 없이 파괴된다.
 *  따라서, 연쇄 반응은 없다.
 *
 *  봄버맨은 폭탄에 면역력을 가지고 있어서,
 *  격자판의 모든 칸을 자유롭게 이동할 수 있다
 *
 *  1)
 *  가장 처음에 봄버맨은 일부 칸에 폭탄을 설치해 놓는다. 모든 폭탄이 설치된 시간은 같다.
 *  다음 1초 동안 봄버맨은 아무것도 하지 않는다.
 *
 *  2)
 *  다음 1초 동안 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다.
 *  즉, 모든 칸은 폭탄을 가지고 있게 된다.
 *  폭탄은 모두 동시에 설치했다고 가정한다.
 *
 *  3)
 *  1초가 지난 후에 3초 전에 설치된 폭탄이 모두 폭발한다.
 *
 *
 *
 *  폭탄을 설치해놓은 초기 상태가 주어졌을 때,
 *  N초가 흐른 후의 격자판 상태를 구하려고 한다.
 *
 *
 *  초기 상태를 기준으로
 *
 *  |---1초(초기상태)---2초(초기 폭탄 + 폭탄이 아닌 곳에 모두 폭탄 설치)---3초(폭탄터짐)---|
 *
 *  2초 = 모든 격자판에 폭탄이 설치되는데, 3초 때 터지는 폭탄은 1초 때 설치된 폭탄 기준으로 인접 위치 폭탄이 터짐.
 *  따라서 초기 상태에서 3초 때 터질 폭탄을 따로 구분해야 함.
 *
 *  1초 - 2초 - 3초
 *
 *  3초(폭탄이 터진 직후 다음 주기의 초기 상태) - 4초 - 5초
 *
 *  5초 - 6초 - 7초
 *
 *  7초 - 8초 - 9초
 *
 *  .
 *  .
 *  .
 *
 *  따라서 짝수 초에는 모든 곳의 폭탄이 설치된 상황 (2초 이후)
 *
 */
public class BOJ_16918 {

    static int r, c, n;
    static char[][] map;
    static int[][] bomb;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int time = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        bomb = new int[r][c];


        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = row.charAt(j);

                if (map[i][j] == 'O') {
                    bomb[i][j] = 3;
                }
            }
        }

        while (time++ < n) {
            if (time % 2 == 0) {
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            // 현 시간부터 3초 뒤에 터진다.
                            bomb[i][j] = time + 3;
                        }
                    }
                }
            } else {
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (bomb[i][j] == time) {
                            bomb(i, j);
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void bomb(int x, int y) {
        map[x][y] = '.';

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                // 동시에 터트려야 하므로, 인접한 폭탄인 경우 같은 시간에 설치된 폭탄은 제외한다.
                if (map[nx][ny] == 'O' && bomb[nx][ny] != time) {
                    bomb[nx][ny] = 0;
                    map[nx][ny] = '.';
                }
            }
        }

    }
}
