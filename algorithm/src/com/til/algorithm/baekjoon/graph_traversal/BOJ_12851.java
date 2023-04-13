package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851 {

    private static int N;
    private static int K;
    private static int shortestPath = Integer.MAX_VALUE;
    private static int shortestPathCnt;
    private static int[] cost = new int[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);
        if (N == K) {
            bw.write(0 + "\n");
            bw.write(1 + "\n");
        } else {
            bw.write(shortestPath + "\n");
            bw.write(shortestPathCnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        cost[start] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (shortestPath < cost[now]) {
                continue;
            }

            int nx;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    nx = now * 2;
                } else if (i == 1) {
                    nx = now + 1;
                } else {
                    nx = now - 1;
                }
                if (nx < 0 || nx > 100_000) {
                    continue;
                }
                if (nx == K) {
                    shortestPath = cost[now];
                    shortestPathCnt++;
                }
                if (cost[nx] == 0 || cost[nx] == cost[now] + 1) {
                    queue.offer(nx);
                    cost[nx] = cost[now] + 1;
                }
            }
        }
        return -1;
    }
}
