package com.til.algorithm.programmers.dev_matching;

public class LV2_행렬테두리회전하기 {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows + 1][columns + 1];
        int val = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = val++;
            }
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int lx = queries[i][0];
            int ly = queries[i][1];
            int rx = queries[i][2];
            int ry = queries[i][3];
            answer[i] = findMin(map, lx, ly, rx, ry);
        }

        return answer;
    }

    private int findMin(int[][] map, int lx, int ly, int rx, int ry) {
        int min = Integer.MAX_VALUE;
        int rightTmp = map[lx][ry];
        int downTmp = map[rx][ry];
        int leftTmp = map[rx][ly];

        min = Math.min(min, rightTmp);
        min = Math.min(min, downTmp);
        min = Math.min(min, leftTmp);

        for (int i = ry; i > ly; i--) {
            map[lx][i] = map[lx][i - 1];
            min = Math.min(min, map[lx][i]);
        }

        for (int i = rx; i > lx; i--) {
            map[i][ry] = map[i - 1][ry];
            min = Math.min(min, map[i][ry]);
        }
        map[lx + 1][ry] = rightTmp;

        for (int i = ly; i < ry; i++) {
            map[rx][i] = map[rx][i + 1];
            min = Math.min(min, map[rx][i]);
        }
        map[rx][ry - 1] = downTmp;

        for (int i = lx; i < rx; i++) {
            map[i][ly] = map[i + 1][ly];
            min = Math.min(min, map[i][ly]);
        }
        map[rx - 1][ly] = leftTmp;

        return min;
    }
}
