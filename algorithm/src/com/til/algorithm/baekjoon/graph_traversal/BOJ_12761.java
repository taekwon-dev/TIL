package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12761 {
    static class Node {
        int v;
        int dist;

        public Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }
    static int a, b, n, m;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[100000 + 1];
        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        int[] nexts = {-1, 1, -a, -b, a, b, a, b};
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 0));
        visited[n] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.v == m) {
                result = node.dist;
                break;
            }

            for (int i = 0; i < 8; i++) {
                int next = node.v;
                if (i < 6) {
                    next += nexts[i];
                } else {
                    next *= nexts[i];
                }
                if (next >= 0 && next <= 100000) {
                    if (!visited[next]) {
                        queue.add(new Node(next, node.dist + 1));
                        visited[next] = true;
                    }
                }
            }
        }
    }
}
