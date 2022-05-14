package com.til.algorithm.baekjoon.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/05.
 * Title : 유기농 배추 (https://www.acmicpc.net/problem/1012)
 * Hint  : 영역 개수 → "각 노드를 방문하면서 처리한 뒤, 카운트" → DFS
 */
public class BOJ_1012 {

    static int m; // 가로 길이
    static int n; // 세로 길이
    static int k; // 배추가 심어진 노드 좌표 수

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            // 각 테스트 케이스 별로 답 초기화
            result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            map = new int[m][n];
            visited = new boolean[m][n];

            k = Integer.parseInt(st.nextToken());

            for (int j = 0; j < k; j++) {
                // 배추가 심어진 위치 좌표 (예시 - X, Y) 읽기
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                // 배추가 심어진 위치에 '1' 표기
                map[x][y] = 1;
            }

            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (!visited[x][y] && map[x][y] == 1) {
                        dfs(x, y);
                        result++;
                    }
                }
            }

            System.out.println(result);

        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 주어진 맵 범위 내 조건에서
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
