package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549 {
    static int n, k;
    static int[] dx = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bfs();
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100_001];
        queue.add(new int[]{n, 0});
        visited[n] = true;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0];
            int cost = arr[1];
            if (x == k) {
                System.out.println(cost);
                return;
            }
            int jump = x * 2;
            if (jump <= 100_000 && !visited[jump]) {
                visited[jump] = true;
                queue.add(new int[]{jump, cost});
            }
            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i];
                if (nx >= 0 && nx <= 100_000 && !visited[nx]) {
                    visited[nx] = true;
                    queue.add(new int[]{nx, cost + 1});
                }
            }
        }
    }
}
