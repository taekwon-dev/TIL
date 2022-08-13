package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  트리의 부모 찾기
 *
 *  루트 없는 트리가 주어진다.
 *
 *  이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
 *
 *  2 <= N (노드 개수) <= 100,00
 *
 *  노드 간 양방향 연결 시 방문 여부를 체크 해야 한다.
 *
 *
 */
public class BOJ_11725 {
    static int n;
    static ArrayList<Integer>[] adjList;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);
        }
        bfs(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int adj : adjList[now]) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    arr[adj] = now;
                    queue.add(adj);
                }
            }
        }
    }

}
