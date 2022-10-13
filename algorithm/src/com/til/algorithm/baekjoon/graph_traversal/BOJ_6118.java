package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_6118 {
    static class Node implements Comparable<Node> {
        int v;
        int dist;

        public Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            if (this.dist == o.dist) {
                return this.v - o.v;
            }
            return this.dist - o.dist;
        }
    }
    static int n, m;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int max;
    static ArrayList<Node> nodeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adjList[s].add(e);
            adjList[e].add(s);
        }
        visited = new boolean[n + 1];
        bfs();
        Collections.sort(nodeList);
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i).dist == max) {
                System.out.println(nodeList.get(i).v);
                break;
            }
        }
        int count = 0;
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i).dist == max) {
                count++;
            }
        }
        System.out.println(max);
        System.out.println(count);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));
        visited[1] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            nodeList.add(node);
            max = Math.max(max, node.dist);

            for (int adj : adjList[node.v]) {
                if (!visited[adj]) {
                    queue.add(new Node(adj, node.dist + 1));
                    visited[adj] = true;
                }
            }
        }
    }
}
