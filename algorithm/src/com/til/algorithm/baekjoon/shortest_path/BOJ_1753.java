package com.til.algorithm.baekjoon.shortest_path;

import java.io.*;
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

    private static int V;
    private static int E;
    private static int S;
    private static int[] dist;
    private static ArrayList<Node>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(br.readLine());
        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        adjList = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjList[from].add(new Node(to, cost));
        }
        dijkstra();

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                bw.write("INF");
            } else {
                bw.write(dist[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra() {
        dist[S] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(S, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (dist[node.v] < node.cost) {
                continue;
            }

            for (int i = 0; i < adjList[node.v].size(); i++) {
                int cost = dist[node.v] + adjList[node.v].get(i).cost;
                if (cost < dist[adjList[node.v].get(i).v]) {
                    dist[adjList[node.v].get(i).v] = cost;
                    pq.offer(new Node(adjList[node.v].get(i).v, cost));
                }
            }
        }
    }
}