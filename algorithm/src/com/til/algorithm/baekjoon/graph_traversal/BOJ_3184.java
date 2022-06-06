package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/02.
 * Title : 양 (https://www.acmicpc.net/problem/3184)
 * Hint  :
 */
public class BOJ_3184 {

    static int r, c;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int sheep, wolf;
    static int sheeps, wovles;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && (map[i][j] == 'o' || map[i][j] == 'v' || map[i][j] == '.')) {

                    sheep = 0;
                    wolf = 0;

                    dfs(i, j);
                    // 한 영역 검사가 끝났을 때 해당 영역의 양과 늑대의 수를 비교
                    if (sheep > wolf) {
                        wolf = 0;
                    } else {
                        sheep = 0;
                    }
                    sheeps += sheep;
                    wovles += wolf;
                }
            }
        }

        System.out.println(sheeps + " " + wovles);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        if (map[x][y] == 'o') {
            sheep += 1;
        } else if (map[x][y] == 'v') {
            wolf += 1;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                if (!visited[nx][ny] && (map[nx][ny] == 'o' || map[nx][ny] == 'v' || map[nx][ny] == '.')) {
                    dfs(nx, ny);
                }
            }

        }
    }

}
