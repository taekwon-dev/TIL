package com.til.algorithm.programmers.dev_matching;

public class LV2_행렬테두리회전하기 {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows + 1][columns + 1];
        int val = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = val++;
            }
        }
        int[] answer = new int[queries.length];
        int idx = 0;
        for (int[] query : queries) {
            int lx = query[0] - 1;
            int ly = query[1] - 1;
            int rx = query[2] - 1;
            int ry = query[3] - 1;
            answer[idx++] = rotate(map, lx, ly, rx, ry);
        }
        return answer;
    }

    private int rotate(int[][] map, int lx, int ly, int rx, int ry) {
        int min = 10_000;
        int rightTemp = map[lx][ry];
        int downTemp = map[rx][ry];
        int leftTemp = map[rx][ly];
        min = Math.min(rightTemp, Math.min(downTemp, leftTemp));

        for (int i = ry; i > ly; i--) {
            map[lx][i] = map[lx][i - 1];
            if (min > map[lx][i]) {
                min = map[lx][i];
            }
        }

        for (int i = rx; i > lx; i--) {
            map[i][ry] = map[i - 1][ry];
            if (min > map[i][ry]) {
                min = map[i][ry];
            }
        }
        map[lx + 1][ry] = rightTemp;

        for (int i = ly; i < ry; i++) {
            map[rx][i] = map[rx][i + 1];
            if (min > map[rx][i]) {
                min = map[rx][i];
            }
        }
        map[rx][ry - 1] = downTemp;

        for (int i = lx; i < rx; i++) {
            map[i][ly] = map[i + 1][ly];
            if (min > map[i][ly]) {
                min = map[i][ly];
            }
        }
        map[rx - 1][ly] = leftTemp;
        return min;
    }
}
