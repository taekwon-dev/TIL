package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  DFS & BFS
 *
 *  각 그래프 순회 알고리즘을 사용해서 탐색 결과를 출력하는 문제
 *  단,
 *  - 방문할 수 있는 정점이 여러 개인 경우 -> 정점 번호가 작은 것을 먼저 방문 -> 정렬
 *
 *    간선 정보가
 *    1, 2
 *    1, 3
 *    1, 4
 *    이렇게 들어오면 순차적으로 인접 노드 방문 할 때 노드 번호가 작은 것부터 방문
 *
 *    5, 4
 *    5, 2
 *    이렇게 들어오면, 오름차순으로 정렬 후 인접 노드 방문 처리를 해야함

 *  - 더 이상 방문할 수 있는 점이 없는 경우 종료
 *  - 정점 1 ~ N
 *  - 1 <= N(정점) <= 1000, 1 <= M(간선) <= 10,000)
 *
 *
 */
public class BOJ_1260 {
    static int n, m, v;
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

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
            adjList[to].add(from);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList[i]);
        }

        dfs(v);
        System.out.println(sb.toString());
        visited = new boolean[n + 1];
        sb = new StringBuilder();
        bfs(v);
        System.out.println(sb.toString());
    }

    private static void dfs(int start) {
        visited[start] = true;
        sb.append(start + " ");

        for (int adj : adjList[start]) {
            if (!visited[adj]) {
                dfs(adj);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        sb.append(start + " ");

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int adj : adjList[now]) {
                if (!visited[adj]) {
                    sb.append(adj + " ");
                    queue.add(adj);
                    visited[adj] = true;
                }
            }
        }
    }
}
