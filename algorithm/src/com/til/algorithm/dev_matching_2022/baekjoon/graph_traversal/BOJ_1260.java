package com.til.algorithm.dev_matching_2022.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Youn on 2022/06/27.
 * Title : DFS, BFS (https://www.acmicpc.net/problem/1260)
 * Hint  : 그래프 순회 (DFS, BFS), 인접 리스트, 정점이 낮은 순서 (정렬)
 */
public class BOJ_1260 {

    static int n, m, v;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 간선 수 만큼 입력 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // 무방향 (양방향) 그래프
            adjList[from].add(to);
            adjList[to].add(from);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList[i]);
        }

        dfs(v);
        System.out.println(sb);
        sb = new StringBuilder();
        visited = new boolean[n + 1];
        bfs(v);
        System.out.println(sb);
    }

    // DFS
    private static void dfs(int start) {
        visited[start] = true;
        sb.append(start + " ");

        for (int adj : adjList[start]) {
            if (!visited[adj]) {
                dfs(adj);
            }
        }
    }

    // BFS
    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        sb.append(start + " ");

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int adj : adjList[now]) {
                if (!visited[adj]) {
                    queue.offer(adj);
                    visited[adj] = true;
                    sb.append(adj + " ");
                }
            }
        }
    }
}
