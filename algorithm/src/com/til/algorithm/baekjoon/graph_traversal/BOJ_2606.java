package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2606 {

    private static int V;
    private static int E;
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        adjList = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }
        visited = new boolean[V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }
        dfs(1);

        bw.write(answer - 1 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int start) {
        visited[start] = true;
        answer++;

        for (int adj : adjList[start]) {
            if (!visited[adj]) {
                dfs(adj);
            }
        }
    }
}