package com.til.algorithm.programmers.kakao.tech_internship_2021;

import java.util.Queue;
import java.util.LinkedList;

public class LV2_거리두기확인하기 {

    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int idx = 0; idx < places.length; idx++) {
            String[] place = places[idx];

            boolean flag = true;
            outer:
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (place[i].charAt(j) == 'P') {
                        if (!bfs(i, j, place)) {
                            flag = false;
                            break outer;
                        }
                    }
                }
            }
            answer[idx] = flag ? 1 : 0;
        }
        return answer;
    }

    private boolean bfs(int x, int y, String[] place) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || ny < 0 || nx > 4 || ny > 4 || (nx == x && ny == y)) {
                    continue;
                }
                int dist = Math.abs(nx - x) + Math.abs(ny - y);

                if (place[nx].charAt(ny) == 'P' && dist <= 2) {
                    return false;
                }
                if (place[nx].charAt(ny) == 'O' && dist < 2) {
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return true;
    }
}