package com.til.algorithm.baekjoon.graph_traversal;

import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/27.
 * Title : 빙산 (https://www.acmicpc.net/problem/2573)
 * Hint  : 매 해마다 (변한 맵 상태를 인풋값으로 활용) 덩어리 수를 카운트 해서 두 개의 덩어리가 되는 최초의 순간을 찾는다.
 *
 *         한 덩어리의 빙산이 주어진다.
 *         만일 전부 다 녹을 때까지 두 덩어리 이상으로 분리되지 않으면 프로그램은 0을 출력한다.
 *
 */
public class BOJ_2573 {
    static int n, m;
    static int[][] map;
    static int[][] melt;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        melt = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            int count = 0;

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    if (!visited[i][j] && map[i][j] != 0) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            if (count == 0) {
                System.out.println(0);
                break;
            }

            if (count >= 2) {
                System.out.println(result);
                break;
            }
            melting();
            result++;
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 1 && ny >= 1 && nx < n + 1 && ny < m + 1) {
                if (map[nx][ny] == 0) {
                    melt[x][y]++;
                }
                if (!visited[nx][ny] && map[nx][ny] != 0) {
                    dfs(nx, ny);
                }
            }
        }
    }


    private static void melting() {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                map[i][j] -= melt[i][j];
                if (map[i][j] < 0) {
                    map[i][j] = 0;
                }
                visited[i][j] = false;
                melt[i][j] = 0;
            }
        }
    }
}
