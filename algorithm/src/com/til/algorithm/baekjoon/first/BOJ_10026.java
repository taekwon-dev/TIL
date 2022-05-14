package com.til.algorithm.baekjoon.first;

import java.util.Scanner;

/**
 * Created by Youn on 2022/04/27.
 * Title : 적록색약 (https://www.acmicpc.net/problem/10026)
 * Hint  :
 *
 */
public class BOJ_10026 {

    static int map[][];
    static boolean visited[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 크기가 N x N 인 그리드
        int n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            // 첫 번째 행 (예 - RRRGB)
            String row = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        // ~ 적록색약
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        int normalCount = count;
        count = 0;
        visited = new boolean[n][n];
        // 적록색약
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // G - R 을 하나의 문자로 치환 (G -> R or R -> G)
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        int nonNormalCount = count;
        System.out.println(normalCount + " " + nonNormalCount);
    }

    private static void dfs(int x, int y) {
        // 해당 좌표를 방문 시점이므로, 해당 좌표 값 방문 처리
        visited[x][y] = true;

        // → 이동 할 수 있다 (AND) 이전 좌표 값과 이동할 좌표 값이 같다 (AND) 방문한 적 없다
        if (y < map.length - 1 && map[x][y] == map[x][y+1] && !visited[x][y+1]) {
            dfs(x, y+1);
        }

        if (y > 0 && map[x][y] == map[x][y-1] && !visited[x][y-1]) {
            dfs(x, y-1);
        }

        if (x < map.length - 1 && map[x][y] == map[x+1][y] && !visited[x+1][y]) {
            dfs(x+1, y);
        }

        if (x > 0 && map[x][y] == map[x-1][y] && !visited[x-1][y]) {
            dfs(x-1, y);
        }
    }

}
