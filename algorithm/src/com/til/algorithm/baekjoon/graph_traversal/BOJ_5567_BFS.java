package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/06.
 * Title : 결혼식 (https://www.acmicpc.net/problem/5567)
 * Hint  :
 */
public class BOJ_5567_BFS {

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

        bfs(1);
        System.out.println(result);

    }

    private static void bfs(int start) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            if (count == adjList[start].size() + 1) {
                break;
            }
            int now = queue.poll();
            count += 1;
            for (int adj : adjList[now]) {
                if (!visited[adj]) {
                    queue.add(adj);
                    visited[adj] = true;
                    result += 1;
                }
            }
        }
    }

}
