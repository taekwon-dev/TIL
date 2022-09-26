package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
