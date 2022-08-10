package com.til.algorithm.baekjoon.graph_traversal;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 *  단지번호붙이기
 *
 *  1 -> 집 O
 *  0 -> 집 X
 *
 *  단지 = 영역
 *
 *  단지수 = 영역 개수
 *  단지에 속하는 집의 수 = 영역 크기 (오름 차순)
 */

public class BOJ_2667 {
    static int n;
    static int danjiCnt, danjiSize;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        ArrayList<Integer> danji = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    danjiCnt++;
                    danji.add(danjiSize);
                    danjiSize = 0;
                }
            }
        }
        System.out.println(danjiCnt);
        Collections.sort(danji);
        for (int size : danji) {
            System.out.println(size);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        danjiSize++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
