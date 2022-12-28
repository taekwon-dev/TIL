package com.til.algorithm.baekjoon.bigstone.week_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1325 {
    private static int n;
    private static int m;
    private static List<Integer>[] adjList;
    private static int[] computer;
    private static boolean[] hacked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        computer = new int[n + 1];
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
        }

        for (int i = 1; i <= n; i++) {
            hacked = new boolean[n + 1];
            dfs(i);
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, computer[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (computer[i] == max) {
                sb.append(i).append(" ");
            }
        }
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int start) {
        hacked[start] = true;

        for (int adj : adjList[start]) {
            if (!hacked[adj]) {
                computer[adj]++;
                dfs(adj);
            }
        }
    }
}