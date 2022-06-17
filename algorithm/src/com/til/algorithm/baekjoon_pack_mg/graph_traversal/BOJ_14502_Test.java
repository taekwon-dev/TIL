package com.til.algorithm.baekjoon_pack_mg.graph_traversal;

/**
 * Created by Youn on 2022/06/17.
 * Title : 연구소 (https://www.acmicpc.net/problem/14502)
 * Hint  : 3개의 벽 세우기 (Combination)
 */
public class BOJ_14502_Test {

    static int n = 1, m = 2;
    static int map[][];

    public static void main(String[] args) {
        map = new int[n][m];
        dfs(0);
    }

    // Combination
    private static void dfs(int wall) {
        if (wall == 2) {
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    System.out.println("i = " + i + " j = " + j);
                    map[i][j] = 1;
                    dfs(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
}
