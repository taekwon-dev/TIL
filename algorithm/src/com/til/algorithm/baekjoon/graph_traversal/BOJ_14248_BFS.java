package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/06.
 * Title : 점프 점프 (https://www.acmicpc.net/problem/14248)
 * Hint  : 방문한 곳을 굳이 방문 처리할 이유가 없음
 */
public class BOJ_14248_BFS {

    static int n, s;
    static boolean[] visited;
    static int[] stones;
    static int[] dirs = {-1, 1};
    static int result = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        stones = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }
        s = Integer.parseInt(br.readLine());

        bfs(s);
        System.out.println(result);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int dir : dirs) {
                int next = dir * stones[now] + now;

                if ((next >= 1 && next <= n) && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    result++;
                }
            }

        }
    }
}
