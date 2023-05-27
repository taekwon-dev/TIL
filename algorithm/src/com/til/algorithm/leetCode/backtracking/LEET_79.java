package com.til.algorithm.leetCode.backtracking;

public class LEET_79 {

    private static boolean[][] visited;

    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (search(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean search(char[][] board, String word, int idx, int x, int y) {
        if (idx == word.length()) {
            return true;
        }
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        if (word.charAt(idx) != board[x][y]) {
            return false;
        }
        visited[x][y] = true;
        boolean result = search(board, word, idx + 1, x + 1, y) || search(board, word, idx + 1, x - 1, y) || search(board, word, idx + 1, x, y + 1) || search(board, word, idx + 1, x, y - 1);
        if (!result) {
            visited[x][y] = false;
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABZ";

        exist(board, word);
    }
}
