package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/31.
 * Title : 바이러스 (https://www.acmicpc.net/problem/2606)
 * Hint  : 인접 리스트
 */
public class BOJ_2606_Adj_List {

    static int n, m;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        adjList = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList[start].add(end);
            adjList[end].add(start);
        }

//        dfs(1);
        bfs(1);
        System.out.println(result);

    }

    private static void dfs(int v) {
        visited[v] = true;
        for (int adj : adjList[v]) {
            if (!visited[adj]) {
                result++;
                dfs(adj);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int adj : adjList[curr]) {
                if (!visited[adj]) {
                    result++;
                    queue.add(adj);
                    visited[adj] = true;
                }
            }
        }
    }

}
