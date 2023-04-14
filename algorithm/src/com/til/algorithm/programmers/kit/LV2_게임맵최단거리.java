package com.til.algorithm.programmers.kit;

import java.util.Queue;
import java.util.LinkedList;

public class LV2_게임맵최단거리 {

    private int[][] maps;
    private boolean[][] visited;
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public int solution(int[][] maps) {
        this.maps = maps;
        visited = new boolean[maps.length][maps[0].length];

        return bfs();
    }

    private int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == maps.length - 1 && now[1] == maps[0].length - 1) {
                return now[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || ny < 0 || nx > maps.length - 1 || ny > maps[0].length - 1) {
                    continue;
                }
                if (!visited[nx][ny] && maps[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny, now[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}