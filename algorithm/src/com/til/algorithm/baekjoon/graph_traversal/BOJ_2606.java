package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2606 {

    private static boolean[] visited;
    private static List<Integer>[] adjList;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());

        visited = new boolean[v + 1];
        adjList = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            adjList[i] = new ArrayList<>();
        }

        int e = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }

        dfs(1);
        System.out.println(answer);
    }

    private static void dfs(int start) {
        visited[start] = true;

        for (int adj : adjList[start]) {
            if (!visited[adj]) {
                answer++;
                dfs(adj);
            }
        }
    }
}
