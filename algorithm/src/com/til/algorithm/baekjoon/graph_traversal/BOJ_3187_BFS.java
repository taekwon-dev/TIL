package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/01.
 * Title : 양치기 꿍 (https://www.acmicpc.net/problem/3187)
 * Hint  :
 */
public class BOJ_3187_BFS {

    static int r, c;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int wolf;
    static int sheep;
    static int wolves;
    static int sheeps;

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
                if (!visited[i][j] && (map[i][j] == '.' || map[i][j] == 'k' || map[i][j] == 'v')) {
                    bfs(i, j);

                    // 한 영역이 끝난 지점 > 계산 > 초기화
                    if (sheep > wolf) {
                        wolf = 0;
                    } else {
                        sheep = 0;
                    }
                    sheeps += sheep;
                    wolves += wolf;

                    wolf = 0;
                    sheep = 0;
                }
            }
        }
        System.out.println(sheeps + " " + wolves);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] currs = queue.poll();
            int currX = currs[0];
            int currY = currs[1];

            if (map[currX][currY] == 'k') {
                sheep++;
            }

            if (map[currX][currY] == 'v') {
                wolf++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = currX + dx[i];
                int ny = currY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    if (!visited[nx][ny] && (map[nx][ny] == '.' || map[nx][ny] == 'k' || map[nx][ny] == 'v')) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
