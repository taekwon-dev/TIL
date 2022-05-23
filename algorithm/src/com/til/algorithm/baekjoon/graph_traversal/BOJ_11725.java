package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/19.
 * Title : 트리의 부모 찾기 (https://www.acmicpc.net/problem/11725)
 * Hint  : DFS, BFS (인접 행렬을 쓸 수 없는 조건)
 */
public class BOJ_11725 {
    static int n;
    static int[] parents;
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parents = new int[n + 1];
        visited = new boolean[n + 1];
        adjList = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adjList[start].add(end);
            adjList[end].add(start);
        }

//        dfs(1);
        bfs(1);

        for (int i = 2; i < parents.length; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void dfs(int v) {
        visited[v] = true;

        for (int adj : adjList[v]) {
            if (!visited[adj]) {
                parents[adj] = v;
                dfs(adj);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            v = queue.poll();
            for (int adj : adjList[v]) {
                if (!visited[adj]) {
                    parents[adj] = v;
                    queue.offer(adj);
                    visited[adj] = true;
                }
            }
        }
    }

}
