package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  Priority Queue
 */
public class BOJ_13549_b {
    static class Node implements Comparable<Node> {
        int x;
        int cost;

        public Node(int x, int cost) {
            this.x = x;
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
    static int[] dx = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        bfs(n, k);
    }

    private static void bfs(int start, int destination) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[100_001];
        pq.add(new Node(start, 0));
        visited[start] = true;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            visited[node.x] = true;

            if (node.x == destination) {
                System.out.println(node.cost);
                return;
            }
            int jump = node.x * 2;
            if (jump <= 100_000 && !visited[jump]) {
                pq.add(new Node(jump, node.cost));
            }
            for (int i = 0; i < 2; i++) {
                int nx = node.x + dx[i];
                if (nx >= 0 && nx <= 100_000 && !visited[nx]) {
                    pq.add(new Node(nx, node.cost + 1));
                }
            }
        }
    }
}
