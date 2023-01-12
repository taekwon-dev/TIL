package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549 {

    private static int N;
    private static int K;
    private static int[] dist = new int[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(dist, -1);
        bfs(N);
        bw.write(dist[K] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        dist[N] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == K) {
                break;
            }
            int jump = now * 2;
            if (jump <= 100_000 && dist[jump] == -1) {
                queue.add(jump);
                dist[jump] = dist[now];
            }
            int nx = -1;
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    nx = now - 1;
                } else if (i == 1) {
                    nx = now + 1;
                }
                if (nx < 0 || nx > 100_000) {
                    continue;
                }
                if (dist[nx] == -1) {
                    queue.add(nx);
                    dist[nx] = dist[now] + 1;
                }
            }
        }
    }
}