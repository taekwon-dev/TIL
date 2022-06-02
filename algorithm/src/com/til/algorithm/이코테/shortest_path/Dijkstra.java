package com.til.algorithm.이코테.shortest_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Youn on 2022/06/02.
 * Title : 다익스트라
 * Hint  :
 */
class Node1 {
    private int index;
    private int distance;

    public Node1(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }
}

public class Dijkstra {
    public static final int INF = (int) 1e9;

    public static int n, m, start;
    public static ArrayList<ArrayList<Node1>> graph = new ArrayList<>();
    public static boolean[] visited = new boolean[100001];
    public static int[] d = new int[100001];

    // 방문하지 않은 노드 중, 가장 최단 거리가 짧은 노드의 번호를 반환 (그리디)
    // 노드의 개수를 매번 선형탐색해서 최단거리 노드를 찾아야 하는 상황 (5000개 이하라면 가능)
    public static int getSmallestNode() {
        int min_value = INF;
        int index = 0;
        for (int i = 0; i < n + 1; i++) {
            if (!visited[i] && d[i] < min_value) {
                min_value = d[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int start) {

        d[start] = 0;
        visited[start] = true;
        for (int j = 0; j < graph.get(start).size(); j++) {
            d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }

        for (int i = 0; i < n - 1; i++) {
            int now = getSmallestNode();
            visited[now] = true;

            for (int j = 0; j < graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).getDistance();

                if (cost < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Node1>());
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(from).add(new Node1(to, cost));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        for (int i = 1; i < n + 1; i++) {
            if (d[i] == INF) {
                System.out.println("INFINITY");
            } else {
                System.out.println(d[i]);
            }
        }
    }
}

