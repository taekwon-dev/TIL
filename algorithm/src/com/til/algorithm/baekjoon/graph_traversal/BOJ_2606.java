package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 바이러스
 * <p>
 * 1번 컴퓨터 -> 시작 노드
 * 시작 노드를 기준으로 그래프 탐색으로 통해 (간선으로 연결된) 노드의 수 구하기 (이 때 시작노드 컴퓨터는 카운팅에서 제외)
 * 무방향 그래프 (-> 양방향)
 */
public class BOJ_2606 {

    static int n, m;
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }
        bfs(1);
        System.out.println(answer);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int adj : adjList[now]) {
                if (!visited[adj]) {
                    answer++;
                    queue.add(adj);
                    visited[adj] = true;
                }
            }
        }
    }
}
