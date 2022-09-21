package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 효율적인 해킹
 * <p>
 * A -> B 신뢰하면, B를 해킹하면 A 까지 해킹할 수 있음
 * <p>
 * 1 <= N (컴퓨터) <= 10,000
 * 1 <= M (신뢰관계) <= 100,000
 * <p>
 * 신뢰를 받는 컴퓨터를 대상으로 역으로 탐색을 하면 연결된 컴퓨터 수를 구할 수 있음
 * 간선 방향을 역으로 주면 일반 그래프 탐색문제와 동일
 * <p>
 * O (V + E) -> 각 정점을 시작 노드로 검사 -> O (V^N + E)
 */
public class BOJ_1325 {
    static int n, m;
    static int[] counts;
    static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        counts = new int[n + 1];
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()); // 신뢰 대상이 되는 컴퓨터
            int to = Integer.parseInt(st.nextToken());  // 신뢰를 하는 컴퓨터
            adjList[from].add(to);
        }

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, counts[i]);
        }
        for (int i = 1; i <= n; i++) {
            if (max == counts[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void bfs(int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int adj : adjList[now]) {
                if (!visited[adj]) {
                    queue.add(adj);
                    visited[adj] = true;
                    counts[adj]++;
                }
            }
        }
    }

}
