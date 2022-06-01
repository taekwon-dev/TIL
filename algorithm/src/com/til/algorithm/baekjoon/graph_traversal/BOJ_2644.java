package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/28.
 * Title : 촌수계산 (https://www.acmicpc.net/problem/2644)
 * Hint  : https://myeongju00.tistory.com/18
 */
public class BOJ_2644 {

    static int n, m;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int end;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adjList = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);
        }
        dfs(start, 0);
        System.out.println(result);
    }

    private static void dfs(int start, int count) {
        visited[start] = true;
        for (int adj : adjList[start]) {
            if (!visited[adj]) {
                if (adj == end) {
                    result = count + 1;
                    return;
                }
                dfs(adj, count + 1);
            }
        }
    }
}
