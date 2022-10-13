package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {

    static int n, k;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dist = new int[100000 + 1];
        bfs();
        System.out.println(dist[k]);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == k) {
                break;
            }

            if (now - 1 >= 0 && dist[now - 1] == 0) {
                queue.add(now - 1);
                dist[now - 1] = dist[now] + 1;
            }
            if (now + 1 <= 100000 && dist[now + 1] == 0) {
                queue.add(now + 1);
                dist[now + 1] = dist[now] + 1;
            }
            if (now * 2 <= 100000 && dist[now * 2] == 0) {
                queue.add(now * 2);
                dist[now * 2] = dist[now] + 1;
            }
        }
    }


}
