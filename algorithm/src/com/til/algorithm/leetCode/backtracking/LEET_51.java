package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_51 {

    private int[] queen;
    private char[][] board;
    private List<List<String>> answer = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        queen = new int[n];
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<int[]> queens = new ArrayList<>();

        backtracking(board, 0, queens);
        return answer;
    }

    private void backtracking(char[][] board, int row, List<int[]> queens) {
        if (row == board.length) {
            List<String> rows = new ArrayList<>();
            for (char[] r : board) {
                rows.add(new String(r));
            }
            answer.add(rows);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            queen[row] = col;
            if (canAddQueen(row)) {
                board[row][col] = 'Q';
                queens.add(new int[]{row, col});
                backtracking(board, row + 1, queens);
                queens.remove(queens.size() - 1);
                board[row][col] = '.';
            }
        }
    }

    private boolean canAddQueen(int row) {
        for (int i = 0; i < row; i++) {
            if (queen[row] == queen[i]) {
                return false;
            }
            if (Math.abs(row - i) == Math.abs(queen[row] - queen[i])) {
                return false;
            }
        }
        return true;
    }
}
