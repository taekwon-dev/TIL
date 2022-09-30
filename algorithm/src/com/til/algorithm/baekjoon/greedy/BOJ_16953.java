package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953 {
    static class Node {
        long val;
        int cnt;

        public Node(long val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
    static long a;
    static long b;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        int result = bfs();
        if (flag) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(a, 1));
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();

            if (node.val == b) {
                flag = true;
                break;
            }
            if (node.val * 2 <= b) {
                queue.offer(new Node(node.val * 2, node.cnt + 1));
            }
            if (node.val * 10 + 1 <= b) {
                queue.offer(new Node(node.val * 10 + 1, node.cnt + 1));
            }
        }
        return node.cnt;
    }
}
