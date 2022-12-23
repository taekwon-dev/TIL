package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2644 {

    private static int n;
    private static boolean[] visited;
    private static List<Integer>[] adjList;
    private static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        int e = Integer.parseInt(br.readLine());
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjList[x].add(y);
            adjList[y].add(x);
        }
        dfs(p1, p2, 0);
        System.out.println(answer);
    }

    private static void dfs(int p1, int p2, int count) {
        if (p1 == p2) {
            answer = count;
            return;
        }
        visited[p1] = true;
        for (int adj : adjList[p1]) {
            if (!visited[adj]) {
                dfs(adj, p2, count + 1);
            }
        }
    }
}