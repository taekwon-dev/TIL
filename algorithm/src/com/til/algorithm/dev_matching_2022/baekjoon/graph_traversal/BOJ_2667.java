package com.til.algorithm.dev_matching_2022.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Youn on 2022/06/27.
 * Title : 단지번호붙이기 (https://www.acmicpc.net/problem/2667)
 * Hint  : 단지수 (= 영역 수), 단지에 속하는 집의 수 (각 영역의 정점 수)
 */
public class BOJ_2667 {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int eachCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                // char to int
                map[i][j] = row.charAt(j) - '0';
            }
        }

        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    // 한 영역 순회가 끝났을 때 eachCount를 단지 수 리스트에 추가
                    results.add(eachCount);
                    // 추가 뒤 각 영역의 정점 수 0으로 초기화
                    eachCount = 0;
                }
            }
        }

        System.out.println(results.size());
        Collections.sort(results);
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        // 각 영역 내에서 정점 방문 시 카운트 + 1
        eachCount += 1;

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
