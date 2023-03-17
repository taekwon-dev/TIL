package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.*;

public class BOJ_1260 {

    private static int N;
    private static int M;
    private static int V;
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i]);
        }
        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        for (int adj : adjList[start]) {
            if (!visited[adj]) {
                dfs(adj);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int adj : adjList[curr]) {
                if (!visited[adj]) {
                    queue.offer(adj);
                    visited[adj] = true;
                    sb.append(adj).append(" ");
                }
            }
        }
    }
}