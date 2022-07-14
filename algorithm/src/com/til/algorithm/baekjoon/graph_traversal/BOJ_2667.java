package com.til.algorithm.baekjoon.graph_traversal;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 *  단지번호붙이기
 *
 *  단지 = 영역
 *  단지 별로 번호를 붙인다. 예를 들어 3개의 단지가 있으면 각 단지는 1, 2, 3
 *  그리고, 각 단지에 속한 집 수를 구한다.
 *
 *  출력
 *  단지수
 *  각 단지에 속하는 집의 수 -> 오름차순
 */
public class BOJ_2667 {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int count = 0;
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

        ArrayList<Integer> regions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    // 각 단지 수에 포함된 집의 수 추가 -> 이 리스트 사이즈 = 단지 수
                    regions.add(count);
                    // 각 단지 수에 포함된 집의 수 초기화
                    count = 0;
                }
            }
        }
        Collections.sort(regions);
        System.out.println(regions.size());
        for (int i = 0; i < regions.size(); i++) {
            System.out.println(regions.get(i));
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

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
