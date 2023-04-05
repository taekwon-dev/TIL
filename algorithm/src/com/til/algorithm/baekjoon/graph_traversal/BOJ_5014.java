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
            int[] curr = queue.poll();
            if (curr[0] == G) {
                return curr[1];
            }
            if (curr[0] + U <= F && !visited[curr[0] + U]) {
                queue.offer(new int[]{curr[0] + U, curr[1] + 1});
                visited[curr[0] + U] = true;
            }
            if (curr[0] - D >= 1 && !visited[curr[0] - D]) {
                queue.offer(new int[]{curr[0] - D, curr[1] + 1});
                visited[curr[0] - D] = true;
            }
        }
        return -1;
    }
}