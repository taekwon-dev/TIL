package com.til.algorithm.baekjoon.shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/02.
 * Title : 특정 거리의 도시 (https://www.acmicpc.net/problem/18352)
 * Hint  : 다익스트라 최단 거리 알고리즘 적용 (문제 특성 = 가중치 1에 맞추지 않음) (https://do-oni.tistory.com/76)
 */
public class BOJ_18352_Dijkstra {

    static int n, m, k, x;
    static ArrayList<Node>[] adjList;
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
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adjList[from].add(new Node(end, 1));
        }
        dist[x] = 0;
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
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.vertex;
            int cost = node.cost;

            if (dist[now] < cost) {
                continue;
            }

            for (int i = 0; i < adjList[now].size(); i++) {
                int adj = adjList[now].get(i).vertex;
                int adj_cost = adjList[now].get(i).cost + cost;

                if (dist[adj] > adj_cost) {
                    dist[adj] = adj_cost;
                    pq.offer(new Node(adj, adj_cost));
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {

        private int vertex;
        private int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}
