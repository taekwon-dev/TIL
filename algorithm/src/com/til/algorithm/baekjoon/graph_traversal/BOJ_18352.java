package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.*;

public class BOJ_18352 {

    private static int N;
    private static int M;
    private static int K;
    private static int X;
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
        }

        bfs(X);

        if (answer.size() == 0) {
            bw.write(-1 + "\n");
        } else {
            StringBuilder sb = new StringBuilder();
            Collections.sort(answer);
            for (int node : answer) {
                sb.append(node).append("\n");
            }
            bw.write(sb.toString() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[1] == K) {
                answer.add(now[0]);
            }

            for (int adj : adjList[now[0]]) {
                if (!visited[adj]) {
                    queue.offer(new int[]{adj, now[1] + 1});
                    visited[adj] = true;
                }
            }
        }
    }
}