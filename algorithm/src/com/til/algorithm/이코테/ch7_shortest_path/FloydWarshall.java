package com.til.algorithm.이코테.ch7_shortest_path;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Youn on 2022/06/03.
 * Title : 플로이드 워셜 알고리즘 + DP
 * Hint  :
 */
public class FloydWarshall {

    private static final int INF = (int) 1e9;
    public static int n, m;
    public static int[][] graph = new int[501][501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < 501; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int a = 1; a < n + 1; a++) {
            for (int b = 1; b < n + 1; b++) {
                if (a == b) {
                    graph[a][b] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = c;
        }

        for (int k = 1; k < n + 1; k++) {
            for (int a = 1; a < n + 1; a++) {
                for (int b = 1; b < n + 1; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for (int a = 1; a < n + 1; a++) {
            for (int b = 1; b < n + 1; b++) {
                if (graph[a][b] == INF) {
                    System.out.println("INFINITY");
                } else {
                    System.out.println(graph[a][b] + " ");
                }
            }
            System.out.println();
        }
    }
}
