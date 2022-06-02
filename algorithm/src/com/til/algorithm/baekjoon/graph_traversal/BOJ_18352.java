package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Youn on 2022/06/02.
 * Title : 특정 거리의 도시 찾기 (https://www.acmicpc.net/problem/18352)
 * Hint  : 각 간선의 가중치가 1로 동일, 최소 비용 -> BFS (https://subin-programming.tistory.com/219, https://yangorithm.tistory.com/220)
 */
public class BOJ_18352 {

    static int n, m, k, x;
    static ArrayList<Integer>[] adjList;
    static int[] dist;
    static boolean[] visited;
    static boolean flag = false;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        dist = new int[n + 1]; // (시작점으로부터) 각 정점 별로 거리를 기록
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
        }

        bfs(x);
        for (int i = 1; i < n + 1; i++) {
            if (dist[i] == k) {
                System.out.println(i);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println(-1);
        }


    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int adj : adjList[now]) {
                if (!visited[adj]) {
                    queue.offer(adj);
                    visited[adj] = true;
                    dist[adj] = dist[now] + 1;
                }
            }
        }
    }
}
