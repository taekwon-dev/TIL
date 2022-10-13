package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953 {
    static class Node {
        long num;
        int count;

        public Node(long num, int count) {
            this.num = num;
            this.count = count;
        }
    }
    static long a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, 1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.num == b) {
                return node.count;
            }

            if (node.num * 2 <= b) {
                queue.add(new Node(node.num * 2, node.count + 1));
            }
            if ((node.num * 10) + 1 <= b) {
                queue.add(new Node((node.num * 10) + 1, node.count + 1));
            }
        }
        return -1;
    }
}
