package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/07.
 * Title : 폴짝폴짝 (https://www.acmicpc.net/problem/1326)
 * Hint  : 최소 비용, 가중치 (배수) ←, → 두 방향 모두 가능
 */
public class BOJ_1326 {

    static class Node {
        int index;
        int jump;
        public Node(int index, int jump) {
            this.index = index;
            this.jump = jump;
        }
    }

    static int n, a, b;
    static int[] rocks;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        rocks = new int[n + 1];
        visited = new boolean[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            rocks[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        bfs();
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(a, 0));
        visited[a] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int now = node.index;
            int cnt = node.jump;

            if (now == b) {
                System.out.println(cnt);
                System.exit(0);
            }

            for (int i = 1; now + (rocks[now] * i) <= n; i++) {
                int next = now + rocks[now] * i;
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new Node(next, cnt + 1));
                }
            }

            for (int i = 1; now - (rocks[now] * i) >= 1; i++) {
                int next = now - rocks[now] * i;
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new Node(next, cnt + 1));
                }
            }
        }
        System.out.println(-1);
    }
}
