package com.til.algorithm.programmers.kakao.blind_recruitment_2018;

import java.util.LinkedList;
import java.util.Queue;

public class LV2_프렌즈4블록 {

    private final char EMPTY = '#';
    private boolean[][] erased;

    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray();
        }
        int answer = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            erased = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] == EMPTY) {
                        continue;
                    }
                    if (map[i][j] == map[i][j + 1] && map[i][j] == map[i + 1][j] && map[i][j] == map[i + 1][j + 1]) {
                        erased[i][j] = true;
                        erased[i][j + 1] = true;
                        erased[i + 1][j] = true;
                        erased[i + 1][j + 1] = true;
                        flag = true;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                Queue<Character> queue = new LinkedList<>();
                for (int j = m - 1; j >= 0; j--) {
                    if (erased[j][i]) {
                        answer++;
                    } else {
                        if (map[j][i] != EMPTY) {
                            queue.add(map[j][i]);
                        }
                    }
                }
                int idx = m - 1;
                while (!queue.isEmpty()) {
                    map[idx--][i] = queue.poll();
                }
                for (int k = idx; k >= 0; k--) {
                    map[k][i] = EMPTY;
                }
            }
        }
        return answer;
    }
}
