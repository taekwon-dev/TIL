package com.til.algorithm.이코테.shortest_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Youn on 2022/06/03.
 * Title : 전보 (https://youtu.be/acqm9mM1P6o?t=3325)
 * Hint  : 1 <= 1 N (도시 수) <= 30000,  1 <= M (통로 수) <= 200000
 *         문제 조건 (주의) 전보를 보내는 도시는 카운트 제외 !
 */
public class 전보 {

    static int n, m, c;
    static int[] dist;
    static ArrayList<Node>[] adjList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        adjList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int time = sc.nextInt();

            adjList[from].add(new Node(to, time));
        }

        dist[0] = 0;
        dijkstra();

        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                count += 1;
                max = Math.max(max, dist[i]);
            }
        }
        System.out.println(count - 1 + " " + max);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(c, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.getVertex();
            int cost = node.getCost();

            if (dist[now] < cost) {
                continue;
            }

            for (int i = 0; i < adjList[now].size(); i++) {
                int c = dist[now] + adjList[now].get(i).getCost();
                if (dist[adjList[now].get(i).getVertex()] > c) {
                    dist[adjList[now].get(i).getVertex()] = c;
                    pq.offer(new Node(dist[adjList[now].get(i).getVertex()], c));
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
            if (this.cost < o.cost) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
