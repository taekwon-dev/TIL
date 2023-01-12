package com.til.algorithm.bigstone.week_3;

import java.io.*;
import java.util.*;

public class BOJ_13913 {

    private static int N;
    private static int K;
    private static int[] dist = new int[100_001];
    private static int[] prev = new int[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(dist, -1);

        bfs(N);
        Stack<Integer> stack = new Stack<>();
        int index = K;
        while (index != N) {
            stack.push(index);
            index = prev[index];
        }
        stack.push(N);

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
                break;
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
                if (dist[nx] == -1) {
                    queue.add(nx);
                    dist[nx] = dist[now] + 1;
                    prev[nx] = now;
                }
            }
        }
    }
}