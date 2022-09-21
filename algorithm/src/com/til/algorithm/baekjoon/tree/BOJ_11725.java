package com.til.algorithm.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 트리의 부모 찾기
 */
public class BOJ_11725 {
    static int n;
    static int[] answer;
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        answer = new int[n + 1];
        visited = new boolean[n + 1];
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList[from].add(end);
            adjList[end].add(from);
        }
        bfs(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            for (int child : adjList[parent]) {
                if (!visited[child]) {
                    answer[child] = parent;
                    queue.add(child);
                    visited[child] = true;
                }
            }
        }
    }
}