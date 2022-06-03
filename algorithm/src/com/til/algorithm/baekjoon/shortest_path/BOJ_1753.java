package com.til.algorithm.baekjoon.shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/03.
 * Title : 최단경로 (https://www.acmicpc.net/problem/1753)
 * Hint  : 다익스트라 최단경로 + 우선순위 큐
 */
public class BOJ_1753 {

    static int v, e, start;
    static ArrayList<Node>[] adjList;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        adjList = new ArrayList[v + 1];
        for (int i = 1; i < v + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from].add(new Node(to, weight));
        }


        dijkstra();
        for (int i = 1; i < v + 1; i++) {
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
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.getVertex();
            int cost = node.getCost();

            if (dist[now] < cost) {
                continue;
            }

            for (int i = 0; i < adjList[now].size(); i++) {
                int c = dist[now] + adjList[now].get(i).cost;

                if (c < dist[adjList[now].get(i).vertex]) {
                    dist[adjList[now].get(i).vertex] = c;
                    // 갱신된 거리 값만 우선순위 큐에 반영한다.
                    pq.offer(new Node(adjList[now].get(i).getVertex(), c));
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

        public int getVertex() {
            return this.vertex;
        }

        public int getCost() {
            return this.cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

}
