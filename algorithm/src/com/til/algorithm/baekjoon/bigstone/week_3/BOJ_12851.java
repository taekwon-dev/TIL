package com.til.algorithm.baekjoon.bigstone.week_3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851 {

    private static int N;
    private static int K;
    private static int[] dist = new int[100_001];
    private static int min = Integer.MAX_VALUE;
    private static int min_way = 0;

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
            bw.write(min_way + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (min < dist[now]) {
                continue;
            }

            int[] step = {now - 1, now + 1, now * 2};
            for (int i = 0; i < step.length; i++) {
                int next = step[i];

                if (next < 0 || next > 100_000) {
                    continue;
                }

                if (next == K) {
                    min = dist[now];
                    min_way++;
                }

                if (dist[next] == 0 || dist[next] == dist[now] + 1) {
                    queue.add(next);
                    dist[next] = dist[now] + 1;
                }
            }
        }
    }
}