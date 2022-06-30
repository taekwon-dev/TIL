package com.til.algorithm.dev_matching_2022.baekjoon.shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/28.
 * Title : 최단 경로 (https://www.acmicpc.net/problem/1753)
 * Hint  : 유향 그래프, 최단 경로, 간선 별 가중치가 다를 수 있다. (단 가중치는 1 ~ 10 사이의 값을 갖는다)
 */
public class BOJ_1753 {

    /**
     *  다익스트라, 최단 경로
     *
     *  주어진 시작점을 기준으로 다른 모든 정점으로의 최단 경로
     *
     *  1. 출발 노드를 설정한다.
     *  2. 출발 노드를 기준으로 각 노드의 최소 비용을 저장한다.
     *  3. 방문하지 않은 노드 중에서 `가장 비용이 적은 노드`를 선택한다.
     *  4. 해당 노드를 거쳐서 특정한 노드로 가는 경우를 고려하여 `최소 비용`을 갱신한다.
     *  5. 위 과정에서 3 ~ 4번을 반복한다.
     */

    static class Node implements Comparable<Node>{
        int vertext;
        int cost;

        public Node(int vertext, int cost) {
            this.vertext = vertext;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            if (this.cost < other.cost) {
                return -1;
            }
            return 1;
        }
    }

    static int v, e, start;
    static int[] d;
    static ArrayList<Node>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        d = new int[v + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
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
            if (d[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(d[i]);
            }
        }
    }

    private static void dijkstra() {
        d[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (d[node.vertext] < node.cost) continue;

            for (int i = 0; i < adjList[node.vertext].size(); i++) {
                int cost = d[node.vertext] + adjList[node.vertext].get(i).cost;
                if (cost < d[adjList[node.vertext].get(i).vertext]) {
                    d[adjList[node.vertext].get(i).vertext] = cost;
                    pq.offer(new Node(adjList[node.vertext].get(i).vertext, cost));
                }
            }
        }
    }

}
