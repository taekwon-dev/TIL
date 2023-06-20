package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205 {

    private static int N;
    private static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        int[][] location;

        while (TC-- > 0) {
            N = Integer.parseInt(br.readLine());
            location = new int[N + 2][2];

            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                location[i][0] = x;
                location[i][1] = y;
            }
            adjList = new ArrayList[N + 2];
            for (int i = 0; i < N + 2; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < N + 2; i++) {
                for (int j = i + 1; j < N + 2; j++) {
                    if (manhattan(location[i], location[j]) <= 1000) {
                        adjList[i].add(j);
                        adjList[j].add(i);
                    }
                }
            }
            boolean result = bfs();

            if (result) {
                bw.write("happy" + "\n");
            } else {
                bw.write("sad" + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int manhattan(int[] l1, int[] l2) {
        return Math.abs(l1[0] - l2[0]) + Math.abs(l1[1] - l2[1]);
    }

    private static boolean bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        boolean[] visited = new boolean[N + 2];
        visited[0] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == N + 1) {
                return true;
            }

            for (int adj : adjList[now]) {
                if (!visited[adj]) {
                    queue.offer(adj);
                    visited[adj] = true;
                }
            }
        }
        return false;
    }
}