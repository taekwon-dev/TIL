package com.til.algorithm.baekjoon.graph_traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Youn on 2022/06/06.
 * Title : 숨바꼭질 2 (https://www.acmicpc.net/problem/12851)
 * Hint  : 도착 지점에 위치 했을 때 걸린 시간 최소 시간인 경우
 *         먼저 BFS 를 통해서 최소 시간으로 도달할 수 있는 경우를 찾고, 다른 방법 중 최소 시간으로 도달할 수 있는 경우를 추가로 세는 문제.
 */
public class BOJ_12851 {

    static int n, k;
    static int min = Integer.MAX_VALUE;
    static int result = 0;
    static int[] dist = new int[100001];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        if (n >= k) {
            System.out.println(n - k);
            System.out.println(1);
            return;
        } else {
            bfs();
            System.out.println(min);
            System.out.println(result);
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        dist[n] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (min < dist[now]) continue;

            int[] steps = {now - 1, now + 1, now * 2};
            for (int i = 0; i < 3; i++) {
                int next = steps[i];

                if (next < 0 || next > 100000) continue;

                if (next == k) {
                    min = dist[now];
                    result++;
                }

                if (dist[next] == 0 || dist[next] == dist[now] + 1) {
                    queue.offer(next);
                    dist[next] = dist[now] + 1;
                }

            }


        }
    }

}