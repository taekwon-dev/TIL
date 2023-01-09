package com.til.algorithm.baekjoon.bigstone.week_3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851 {

    private static int N;
    private static int K;
    private static int min = Integer.MAX_VALUE;
    private static int minCount;
    private static int[] dist = new int[100_001];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            bw.write(0 + "\n");
            bw.write(1 + "\n");
        } else {
            bfs(N);
            bw.write(min + "\n");
            bw.write(minCount + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        dist[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (min < dist[now]) {
                continue;
            }

            int nx = -1;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    nx = now - 1;
                } else if (i == 1) {
                    nx = now + 1;
                } else if (i == 2) {
                    nx = now * 2;
                }
                if (nx < 0 || nx > 100_000) {
                    continue;
                }
                if (nx == K) {
                    min = dist[now];
                    minCount++;
                }
                if (dist[nx] == 0 || dist[nx] == dist[now] + 1) {
                    queue.add(nx);
                    dist[nx] = dist[now] + 1;
                }
            }
        }
    }
}