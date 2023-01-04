package com.til.algorithm.baekjoon.bigstone.week_3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_13913 {

    private static int N;
    private static int K;
    private static int[] step = {-1, 1, 2};
    private static int[] dist = new int[100_001];
    private static int[] prev = new int[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);
        Stack<Integer> stack = new Stack<>();
        int index = K;
        while (index != N) {
            stack.push(index);
            index = prev[index];
        }
        stack.push(index);

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        bw.write(dist[K] + "\n");
        bw.write(sb.toString() + "\n");
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
                return;
            }

            int next;
            for (int i = 0; i < step.length; i++) {
                next = now + step[i];
                if (i == 2) {
                    next = now * step[i];
                }

                if (next < 0 || next > 100_000) {
                    continue;
                }

                if (dist[next] == 0 || dist[next] == dist[now] + 1) {
                    queue.add(next);
                    dist[next] = dist[now] + 1;
                    prev[next] = now;
                }
            }
        }
    }
}