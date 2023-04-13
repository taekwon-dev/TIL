package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549 {

    private static int N;
    private static int K;
    private static boolean[] visited = new boolean[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bw.write(bfs(N) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == K) {
                return now[1];
            }
            if (now[0] * 2 <= 100_000 && !visited[now[0] * 2]) {
                queue.offer(new int[]{now[0] * 2, now[1]});
                visited[now[0] * 2] = true;
            }
            if (now[0] - 1 >= 0 && !visited[now[0] - 1]) {
                queue.offer(new int[]{now[0] - 1, now[1] + 1});
                visited[now[0] - 1] = true;
            }
            if (now[0] + 1 <= 100_000 && !visited[now[0] + 1]) {
                queue.offer(new int[]{now[0] + 1, now[1] + 1});
                visited[now[0] + 1] = true;
            }
        }
        return -1;
    }
}