package com.til.algorithm.baekjoon.shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14938 {
    static class Node implements Comparable<Node> {
        int v;
        int dist;

        public Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            if (this.dist < o.dist) {
                return -1;
            }
            return 1;
        }
    }
    static int n, m, r;
    static final int INF = (int) 1e9;
    static int[] items;
    static int[] d;
    static ArrayList<Node>[] adjList;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjList[from].add(new Node(to, cost));
            adjList[to].add(new Node(from, cost));
        }
        for (int i = 1; i <= n; i++) {
            dijkstra(i);
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (d[j] <= m) {
                    count += items[j];
                }
                max = Math.max(max, count);
            }
        }
        System.out.println(max);
    }

    private static void dijkstra(int start) {
        d = new int[n + 1];
        Arrays.fill(d, INF);
        d[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (d[node.v] < node.dist) {
                continue;
            }
            for (int i = 0; i < adjList[node.v].size(); i++) {
                int cost = d[node.v] + adjList[node.v].get(i).dist;
                if (d[adjList[node.v].get(i).v] > cost) {
                    d[adjList[node.v].get(i).v] = cost;
                    pq.add(new Node(adjList[node.v].get(i).v, cost));
                }
            }
        }
    }
}
