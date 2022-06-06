package com.til.algorithm.baekjoon.graph_traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Youn on 2022/06/06.
 * Title : 숨바꼭질
 * Hint  : 인덱스 조건 부합 -> 해당 인덱스 값 체크 순서로 체크 필요
 */
public class BOJ_1697 {

    static int n, k;
    static int[] dist = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        bfs();
        System.out.println(dist[k]);
    }

    private static void bfs() {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == k) {
                break;
            }

            if (now - 1 >= 0 && dist[now - 1] == 0) {
                queue.offer(now - 1);
                dist[now - 1] = dist[now] + 1;
            }

            if (now + 1 <= 100000 && dist[now + 1] == 0) {
                queue.offer(now + 1);
                dist[now + 1] = dist[now] + 1;
            }

            if (now * 2 <= 100000 && dist[now * 2] == 0) {
                queue.offer(now * 2);
                dist[now * 2] = dist[now] + 1;
            }
        }
    }

}
