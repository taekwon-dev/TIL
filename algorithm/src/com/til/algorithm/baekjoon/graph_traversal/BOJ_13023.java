package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13023 {

    private static int N;
    private static int M;
    private static boolean[] visited;
    private static ArrayList<Integer>[] adjList;
    private static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N];
        flag = false;

        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            dfs(i, 0);
            if (flag) {
                break;
            }
        }

        bw.write((flag ? 1 : 0) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int start, int depth) {
        if (depth == 4) {
            flag = true;
            return;
        }
        visited[start] = true;
        for (int adj : adjList[start]) {
            if (!visited[adj]) {
                dfs(adj, depth + 1);
            }
            if (flag) {
                return;
            }
        }
        visited[start] = false;
    }
}