package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/26.
 * Title : DFS와 BFS (https://www.acmicpc.net/problem/1260)
 * Hint  : Graph Traversal (Adjacency Matrix) - 테스트
 *         0  1  1
 *         1  0  1
 *         1  1  0
 */
public class BOJ_1260_Adjacency_Matrix_Test {

    static int n, m, v;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        map = new int[4][4];
        map[1][2] = 1;
        map[1][3] = 1;
        map[2][1] = 1;
        map[2][3] = 1;
        map[3][1] = 1;
        map[3][2] = 1;
        visited = new boolean[4];
        dfs(1);
   }

    private static void dfs(int v) {
        visited[v] = true;
        // 방문 노드
        System.out.println("v = " + v);
        for (int i = 1; i < map.length; i++) {
            if (!visited[i] && map[v][i] == 1) {
                System.out.println("방문 좌표 : " + v + ", " + i);
                // (1, 2)
                // (2, 3) 까지만 찍히고, (1,3) 은 안 찍힌다.
                dfs(i);
            }
        }
    }



}
