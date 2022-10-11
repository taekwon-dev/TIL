package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2644 {
    static int n, m;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int start, end;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }
        dfs(start, 0);
        System.out.println(result);
    }

    private static void dfs(int start, int count) {
        visited[start] = true;
        for (int adj : adjList[start]) {
            if (!visited[adj]) {
                if (adj == end) {
                    result = count + 1;
                    return;
                }
                dfs(adj, count + 1);
            }
        }
    }
}
