package com.til.algorithm.baekjoon.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/04/26.
 * Title : 안전 영역 (https://www.acmicpc.net/problem/2468)
 * Hint  : 문제 속에서 기준을 찾아야 하는 경우
 */
public class BOJ_2468 {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > maxHeight) {
                    maxHeight = map[i][j];
                }
            }
        }

        // 모든 지역이 빗물에 안 잠길 수 있다. (따라서 초기값을 0으로 설정)
        int max = 0;
        for (int height = 0; height < maxHeight; height++) {
            // 기준 높이 별로 방문 여부를 매번 계산해야 한다.
            visited = new boolean[n][n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] > height) {
                        count += dfs(i, j, height);
                    }
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }

    static int dfs(int x, int y, int height) {
        visited[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx > n-1 || ny < 0 || ny > n-1) {
                continue;
            }
            if (visited[nx][ny]) {
                continue;
            }
            if (map[nx][ny] > height) {
                dfs(nx, ny, height);
            }
        }
        return 1;
    }
}
