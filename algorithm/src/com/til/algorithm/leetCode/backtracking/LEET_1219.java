package com.til.algorithm.leetCode.backtracking;

/**
 * Path with Maximum Gold
 */
public class LEET_1219 {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int max = 0;
    public int getMaximumGold(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] != 0) {
                    max = Math.max(max, dfs(grid, visited, i, j));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, boolean[][] visited, int x, int y) {
        int gold = 0;
        visited[x][y] = true;


        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length) {
                if (!visited[nx][ny] && grid[nx][ny] != 0) {
                    gold = Math.max(gold, dfs(grid, visited, nx, ny));
                }
            }
        }
        visited[x][y] = false;
        return gold + grid[x][y];
    }
}
