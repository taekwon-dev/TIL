package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18352 {

    private static int n;
    private static int m;
    private static int k;
    private static int x;
    private static boolean[] visited;
    private static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
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
        }
        bfs(x, 0);
    }

    private static void bfs(int start, int cnt) {
        List<Integer> cities = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, cnt});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[1] == k) {
                cities.add(curr[0]);
            }
            for (int adj : adjList[curr[0]]) {
                if (!visited[adj]) {
                    queue.add(new int[]{adj, curr[1] + 1});
                    visited[adj] = true;
                }
            }
        }

        if (cities.size() == 0) {
            System.out.println(-1);
            return;
        }
        Collections.sort(cities);
        for (int city : cities) {
            System.out.println(city);
        }
    }
}