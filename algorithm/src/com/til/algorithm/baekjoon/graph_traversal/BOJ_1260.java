package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  DFS와 BFS
 *
 *  그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 *  단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
 *  정점 번호는 1번부터 N번까지이다.
 *
 *  정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000)
 *
 */

public class BOJ_1260 {
    static int n, m, v;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }



        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList[i]);
        }


        visited = new boolean[n + 1];
        sb.append(v + " ");
        dfs(v);
        System.out.println(sb.toString());

        sb = new StringBuilder();
        visited = new boolean[n + 1];
        bfs();
        System.out.println(sb.toString());
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        sb.append(v + " ");

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int adj : adjList[now]) {
                if (!visited[adj]) {
                    sb.append(adj + " ");
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }

    private static void dfs(int node) {
        visited[node] = true;

        for (int adj : adjList[node]) {
            if (!visited[adj]) {
                sb.append(adj + " ");
                dfs(adj);
            }
        }
    }
}
