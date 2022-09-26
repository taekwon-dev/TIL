package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260 {
    static int n, m, v;
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;
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
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList[i]);
        }
        dfs(v);
        sb.append("\n");
        bfs(v);
        System.out.println(sb.toString());
    }

    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v + " ");

        for (int adj : adjList[v]) {
            if (!visited[adj]) {
                dfs(adj);
            }
        }
    }

    private static void bfs(int v) {
        visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);
        sb.append(v + " ");

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int adj : adjList[now]) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                    sb.append(adj + " ");
                }
            }
        }
    }
}
