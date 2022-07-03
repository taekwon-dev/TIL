package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/22.
 * Title : 미로 탐색 (https://www.acmicpc.net/problem/2178)
 * Hint  : 최소 비용, 간선의 가중치가 1로 동일, 최종 목적지에 도달할 수 있는 경우의 수라면 가중치가 같으므로 세부 경로가 달라도 결과는 같음 (최소 이동 칸 수)
 */
public class BOJ_2178 {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            String row = br.readLine();
            for (int j = 1; j < m + 1; j++) {
                map[i][j] = row.charAt(j - 1) - '0';
            }
        }

        bfs(1, 1);
        System.out.println(map[n][m]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] currs = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = currs[0] + dx[i];
                int ny = currs[1] + dy[i];

                if (nx >= 1 && ny >= 1 && nx < n + 1 && ny < m + 1) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        map[nx][ny] = map[currs[0]][currs[1]] + 1;
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
