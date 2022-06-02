package com.til.algorithm.baekjoon.shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/02.
 * Title : 특정 거리의 도시 찾기 (https://youngest-programming.tistory.com/536)
 * Hint  : 다익스트라 + 가중치 1인 문제 특성 반영 (https://lotuslee.tistory.com/32)
 */

public class BOJ_18352 {
    static int n, m, k, x;
    static ArrayList<Integer>[] adjList;
    static int[] dist;
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
        dist = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adjList[from].add(end);
        }

        dijkstra();
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

    private static void dijkstra() {
        dist[x] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(x);

        while (!pq.isEmpty()) {
            int now = pq.poll();
            for (int adj : adjList[now]) {
                if (dist[adj] > dist[now] + 1) {
                    dist[adj] = dist[now] + 1;
                    pq.offer(adj);
                }
            }
        }
    }
}