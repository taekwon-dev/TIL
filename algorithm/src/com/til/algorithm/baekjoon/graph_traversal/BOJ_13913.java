package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13913 {

    static class Node {
        int x;
        int dist;

        public Node(int x, int dist) {
            this.x = x;
            this.dist = dist;
        }
    }

    private static int N;
    private static int K;
    private static boolean[] visited;
    private static int[] step = {-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100_001];

        bw.write(bfs(N) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int N) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));
        visited[N] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == K) {
                return node.dist;
            }
            int jump = node.x * 2;
            if (jump <= 100_000 && !visited[jump]) {
                visited[jump] = true;
                queue.add(new Node(jump, node.dist));
            }
            for (int i = 0; i < 2; i++) {
                int nx = node.x + step[i];
                if (nx < 0 || nx > 100_000) {
                    continue;
                }
                if (!visited[nx]) {
                    visited[nx] = true;
                    queue.add(new Node(nx, node.dist + 1));
                }
            }
        }
        return -1;
    }
}