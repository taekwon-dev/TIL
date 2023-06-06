package com.til.algorithm.baekjoon.shortest_path.dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {

    static class Node implements Comparable<Node> {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
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

    private static final int INF = (int) 1e9;

    private static int V, E, K;
    private static int[] dist;
    private static ArrayList<Node>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[K] = 0;

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
            if (dist[i] == INF) {
                bw.write("INF" + "\n");
            } else {
                bw.write(dist[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (dist[node.vertex] < node.cost) {
                continue;
            }

            for (int i = 0; i < adjList[node.vertex].size(); i++) {
                int cost = dist[node.vertex] + adjList[node.vertex].get(i).cost;
                if (dist[adjList[node.vertex].get(i).vertex] > cost) {
                    dist[adjList[node.vertex].get(i).vertex] = cost;
                    pq.offer(new Node(adjList[node.vertex].get(i).vertex, cost));
                }
            }
        }
    }
}