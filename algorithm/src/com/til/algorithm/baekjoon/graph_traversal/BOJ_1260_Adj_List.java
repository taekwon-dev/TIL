package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Youn on 2022/05/19.
 * Title : DFS와 BFS (https://www.acmicpc.net/problem/1260)
 * Hint  : Graph Traversal (Adjacency List)
 */
public class BOJ_1260_Adjacency_List {

    static int n; // 정점 수
    static int m; // 간선 수
    static int v; // 시작 정점

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        sb = new StringBuilder();

        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adjList[start].add(end);
            adjList[end].add(start);
        }
        for (int i = 1; i < n + 1; i++) {
            Collections.sort(adjList[i]);
        }

        dfs(v);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(v);
        System.out.println(sb);
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
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            v = queue.poll();
            sb.append(v + " ");

            for (int adj : adjList[v]) {
                if (!visited[adj]) {
                    queue.add(adj);
                    visited[adj] = true;
                }
            }
        }

    }

}
