package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {

    private static int F;
    private static int S;
    private static int G;
    private static int U;
    private static int D;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visited = new boolean[F + 1];

        int result = bfs();
        if (result == -1) {
            bw.write("use the stairs" + "\n");
        } else {
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{S, 0});
        visited[S] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == G) {
                return now[1];
            }

            int nx = 0;
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    nx = now[0] + U;
                } else {
                    nx = now[0] - D;
                }

                if (nx < 1 || nx > F) {
                    continue;
                }
                if (!visited[nx]) {
                    queue.offer(new int[]{nx, now[1] + 1});
                    visited[nx] = true;
                }
            }
        }
        return -1;
    }
}
