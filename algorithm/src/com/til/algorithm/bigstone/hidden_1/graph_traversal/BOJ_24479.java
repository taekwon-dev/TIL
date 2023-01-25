package com.til.algorithm.bigstone.hidden_1.graph_traversal;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_24479 {

    private static int N;
    private static int M;
    private static int R;
    private static int idx = 1;
    private static int[] answer;
    private static boolean[] visited;
    private static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        answer = new int[N + 1];
        visited = new boolean[N + 1];
        adjList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v);
            adjList[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i]);
        }

        dfs(R);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append("\n");
        }

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int start) {
        visited[start] = true;
        answer[start] = idx++;

        for (int adj : adjList[start]) {
            if (!visited[adj]) {
                dfs(adj);
            }
        }
    }
}