package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5567 {

    private static int N;
    private static int M;
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        bw.write(bfs(1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int start) {
        int invite = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[1] >= 2) {
                break;
            }

            for (int adj : adjList[now[0]]) {
                if (!visited[adj]) {
                    invite++;
                    visited[adj] = true;
                    queue.offer(new int[]{adj, now[1] + 1});
                }
            }
        }
        return invite;
    }
}