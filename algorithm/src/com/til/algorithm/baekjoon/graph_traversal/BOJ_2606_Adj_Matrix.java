package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/19.
 * Title : 바이러스 (https://www.acmicpc.net/problem/2606)
 * Hint  : 인접 행렬
 */
public class BOJ_2606_Adj_Matrix {

    static int n, m;
    static int[][] map;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start][end] = 1;
            map[end][start] = 1;
        }

//        dfs(1);
        bfs(1);
        System.out.println(result);
    }

    private static void dfs(int v) {
        visited[v] = true;
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i] && map[v][i] == 1) {
                result++;
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i] && map[curr][i] == 1) {
                    result++;
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }




}
