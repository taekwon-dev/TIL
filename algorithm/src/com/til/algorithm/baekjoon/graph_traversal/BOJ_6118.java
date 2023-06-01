package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6118 {

    private static int N;
    private static int M;
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static int destination;
    private static int distance;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
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
            adjList[to].add(from);
        }
        bfs(1);

        bw.write(destination + " " + distance + " " + count + "\n");
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

            if (now[1] > distance) {
                distance = now[1];
                destination = now[0];
                count = 1;
            } else if (now[1] == distance) {
                if (destination > now[0]) {
                    destination = now[0];
                }
                count++;
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