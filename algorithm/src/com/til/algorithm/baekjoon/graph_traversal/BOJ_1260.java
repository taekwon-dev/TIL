package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/19.
 * Title : DFS와 BFS (https://www.acmicpc.net/problem/1260)
 * Hint  : Graph Traversal
 *         방문 가능한 정점이 여러 개인 경우, 정점 번호가 작은 것을 먼저 방문한다.
 */
public class BOJ_1260 {

    static int n, m, v;

    static int[][] map;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = 1;
            map[end][start] = 1;
        }

        dfs(v);
        sb.append("\n");
        System.out.println(sb);
    }

    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v + " ");

        for (int i = 1; i < n + 1; i++) {
            if (!visited[v] && map[v][i] == 1) {
                dfs(i);
            }
        }
    }


}
