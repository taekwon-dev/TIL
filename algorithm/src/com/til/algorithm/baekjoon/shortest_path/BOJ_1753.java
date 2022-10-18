package com.til.algorithm.baekjoon.shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
    static class Node implements Comparable<Node> {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static int v, e, start;
    static int[] dist;
    static ArrayList<Node>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        adjList = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjList[from].add(new Node(to, cost));
        }
        dijkstra();
        for (int i = 1; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    private static void dijkstra() {
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (dist[node.v] < node.cost) {
                continue;
            }
            for (int i = 0; i < adjList[node.v].size(); i++) {
                int cost = dist[node.v] + adjList[node.v].get(i).cost;
                if (cost < dist[adjList[node.v].get(i).v]) {
                    dist[adjList[node.v].get(i).v] = cost;
                    pq.add(new Node(adjList[node.v].get(i).v, cost));
                }
            }
        }
    }
}
