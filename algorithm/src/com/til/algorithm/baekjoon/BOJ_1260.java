package com.til.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Youn on 2022/05/04.
 * Title : DFS와 BFS (https://www.acmicpc.net/problem/1260)
 * Hint  : N (1 <= N <= 1000)
 */
public class BOJ_1260 {

    static int n; // 정점 개수
    static int m; // 간선 개수
    static int v; // 시작 정점

    static int[][] map;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        visited = new boolean[n+1];

        // 2차원 배열 (그리드) 형태로 트리 표현
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = 1;
            map[end][start] = 1;
        }

        dfs(v);
        sb.append("\n");
        bfs(v);

        System.out.println(sb);
    }

    private static void dfs(int start) {
        sb.append(start + " ");
        visited[start] = true;

        // 현재 노드 기준 - 간선으로 연결된 노드 + 미방문 상태
        for (int i = 1; i < visited.length; i++) {
            if (i != start && visited[i] == false && map[start][i] == 1) {
                dfs(i);
            }
        }
    }

    private static void initVisited() {
        for (int i = 1; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    private static void bfs(int start) {
        initVisited();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            sb.append(tmp + " ");

            for (int i = 1; i < visited.length; i++) {
                if (i != tmp && visited[i] == false && map[tmp][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        sb.append("\n");
    }
}
