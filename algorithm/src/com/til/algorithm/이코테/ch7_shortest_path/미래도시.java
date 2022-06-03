package com.til.algorithm.이코테.shortest_path;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Youn on 2022/06/03.
 * Title : 미래도시 (https://youtu.be/acqm9mM1P6o?t=3677)
 * Hint  : N 의 크키가 100 -> 플로이드 워셜 알고리즘 활용 가능
 */
public class 미래도시 {

    static int n, m, x, k;
    static int[][] map = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < 101; i++) {
            Arrays.fill(map, Integer.MAX_VALUE);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == j) {
                    map[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            map[from][to] = 1;
            map[to][from] = 1;
        }

        x = sc.nextInt();
        k = sc.nextInt();

        for (int h = 1; h <= n; h++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][h] + map[h][j]);
                }
            }
        }

        if (map[1][k] == Integer.MAX_VALUE || map[k][x] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(map[1][k] + map[k][x]);
        }
    }
}
