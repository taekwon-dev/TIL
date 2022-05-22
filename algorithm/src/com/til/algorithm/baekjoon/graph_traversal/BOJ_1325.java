package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/22.
 * Title : 효율적인 해킹 (https://www.acmicpc.net/problem/1325)
 * Hint  :
 */
public class BOJ_1325 {
    static int n, m;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        dp = new int[n + 1];
        adjList = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList[start].add(end);
        }

        for (int i = 1; i < n + 1; i++) {
            visited = new boolean[n + 1];
            dfs(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            max = Math.max(dp[i], max);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            if (max == dp[i]) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int v) {
        visited[v] = true;
        for (int adj : adjList[v]) {
            if (!visited[adj]) {
                dp[adj]++;
                dfs(adj);
            }
        }
    }
}
