package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5567 {
    static class Node {
        int v;
        int dist;

        public Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }
    static int n, m;
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st = null;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }
        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));
        visited[1] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int adj : adjList[node.v]) {
                if (!visited[adj]) {
                    queue.add(new Node(adj, node.dist + 1));
                    visited[adj] = true;
                    if (node.dist + 1 <= 2) {
                        result++;
                    }
                }
            }
        }
    }

    private static void dfs(int v, int depth) {
        if (depth == 2) {
            return;
        }
        for (int adj : adjList[v]) {
            visited[v] = true;
            dfs(adj, depth + 1);
        }
    }

}
