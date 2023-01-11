package com.til.algorithm.bigstone.week_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 *  V <= 10,000
 *  E <= 100,000
 *
 *  Adjacency List - O(V + E)
 */
public class BOJ_1325_time_out {

    private static int n;
    private static int m;
    private static List<Integer>[] adjList;
    private static boolean[] hacked;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[to].add(from);
        }

        List<Integer> counts = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            count = 0;
            hacked = new boolean[n + 1];
            dfs(i);
            counts.add(count);
        }
        int max = Collections.max(counts);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counts.size(); i++) {
            if (counts.get(i) == max) {
                sb.append(i + 1).append(" ");
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
                count++;
                dfs(adj);
            }
        }
    }
}