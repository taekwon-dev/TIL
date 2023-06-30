package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1325 {

    private static int n;
    private static int m;
    private static boolean[] visited;
    private static List<Integer>[] adjList;
    private static int[] hack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[n + 1];
        hack = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            dfs(i);
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, hack[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (hack[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int start) {
        visited[start] = true;

        for (int adj : adjList[start]) {
            if (!visited[adj]) {
                hack[adj]++;
                dfs(adj);
            }
        }
    }
}
