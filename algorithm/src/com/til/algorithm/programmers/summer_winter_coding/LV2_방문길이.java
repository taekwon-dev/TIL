package com.til.algorithm.programmers.summer_winter_coding;

public class LV2_방문길이 {

    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, -1, 0, 1};

    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];
        int x = 5;
        int y = 5;
        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            int d = 0;
            if (dir == 'U') {
                d = 0;
            } else if (dir == 'L') {
                d = 1;
            } else if (dir == 'D') {
                d = 2;
            } else if (dir == 'R') {
                d = 3;
            }
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || ny < 0 || nx > 10 || ny > 10) {
                continue;
            }
            if (!visited[nx][ny][d]) {
                visited[nx][ny][d] = true;
                if (d % 2 == 0) {
                    d = 2 - d;
                } else {
                    d = 4 - d;
                }
                visited[x][y][d] = true;
                answer++;
            }
            x = nx;
            y = ny;
        }
        return answer;
    }
}