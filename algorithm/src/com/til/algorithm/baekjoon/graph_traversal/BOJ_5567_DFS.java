package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/06.
 * Title : 결혼식 (https://www.acmicpc.net/problem/5567)
 * Hint  :
 */
public class BOJ_5567_DFS {

    static int n, m;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // 양방향 관계
            adjList[from].add(to);
            adjList[to].add(from);
        }

        dfs(1, 0);
        for (int i = 2; i <= n; i++) {
            if (visited[i]) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static void dfs(int start, int index) {
        if (index == 2) {
            return;
        }

        for (int adj : adjList[start]) {
            visited[adj] = true;
            dfs(adj, index + 1);

        }
    }
}
