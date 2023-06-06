package com.til.algorithm.baekjoon.shortest_path.dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18352 {

    static class Node implements Comparable<Node> {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            // 비교 상대의 가중치가 더 큰 경우
            if (this.cost < o.cost) {
                // 오름차순 적용
                return -1;
            }
            return 1;
        }
    }

    private static final int INF = (int) 1e9;

    private static int N, M, K, X;
    private static int[] dist;
    private static ArrayList<Node>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[X] = 0;

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // 가중치 1로 고정 (-> BFS로도 풀 수 있는 근거)
            adjList[from].add(new Node(to, 1));
        }

        dijkstra();
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                answer.append(i + "\n");
            }
        }
        if (answer.length() == 0) {
            bw.write(-1 + "\n");
        } else {
            bw.write(answer.toString() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));

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