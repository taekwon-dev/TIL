package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/19.
 * Title : 바이러스 (https://www.acmicpc.net/problem/2606)
 * Hint  : 그래프 표현 (Adjacency Matrix, Adjacency List), DFS
 *         1번 컴퓨터를 기준으로 연결된 컴퓨터의 수를 세는 과정
 */
public class BOJ_2606 {

    static int[][] map;
    static boolean[] visited;
    static int n; // 정점 수 (= 컴퓨터 수)
    static int m; // 간선 수
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

        dfs(1);
        System.out.println(result);
    }

    private static void dfs(int i) {
        visited[i] = true;

        for (int j = 1; j < n + 1; j++) {
            if (!visited[j] && map[i][j] == 1) {
                result++;
                dfs(j);
            }
        }
    }
}
