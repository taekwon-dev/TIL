package com.til.algorithm.baekjoon.graph_traversal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Youn on 2022/05/22.
 * Title : 단지번호 붙이기 (https://www.acmicpc.net/problem/2667)
 * Hint  :
 */
public class BOJ_2667 {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int count;
    static ArrayList<Integer> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            String row = sc.next();
            for (int j = 1; j < n + 1; j++) {
                map[i][j] = row.charAt(j - 1) - '0';
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    results.add(count);
                    count = 0;
                }
            }
        }

        Collections.sort(results);

        System.out.println(results.size());
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 1 && ny >= 1 && nx < n + 1 && ny < n + 1) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }



}
