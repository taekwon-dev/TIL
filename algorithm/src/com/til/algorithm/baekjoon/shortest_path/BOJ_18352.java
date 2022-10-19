package com.til.algorithm.baekjoon.shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18352 {
    static class Node implements Comparable<Node> {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cost < o.cost) {
                return -1;
            }
            return 1;
        }
    }
    static int n, m, k, x;
    static final int INF = (int) 1e9;
    static int[] dist;
    static ArrayList<Node>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[x] = 0;

        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(new Node(to, 1));
        }

        dijkstra();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dist[i] == k) {
                sb.append(i + "\n");
            }
        }
        if (sb.length() != 0) {
            System.out.println(sb.toString());
        } else {
            System.out.println(-1);
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (dist[node.v] < node.cost) {
                continue;
            }

            for (int i = 0; i < adjList[node.v].size(); i++) {
                int cost = dist[node.v] + adjList[node.v].get(i).cost;
                if (dist[adjList[node.v].get(i).v] > cost) {
                    dist[adjList[node.v].get(i).v] = cost;
                    pq.add(new Node(adjList[node.v].get(i).v, cost));
                }
            }
        }
    }

}
