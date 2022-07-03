package com.til.algorithm.dev_matching_2022.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/07/01.
 * Title : 배열 돌리기 1 (https://www.acmicpc.net/problem/16926)
 * Hint  :
 */
public class BOJ_16926 {

    static int n, m, r;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int groups = Math.min(n, m) / 2;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < groups; j++) {
                int x = j, y = j;
                int temp = map[x][y];
                int index = 0;

                while (index < 4) {
                    int nx = x + dx[index];
                    int ny = y + dy[index];

                    if (nx >= j && ny >= j && nx < n - j && ny < m - j) {
                        map[x][y] = map[nx][ny];
                        x = nx;
                        y = ny;
                    } else {
                        index += 1;
                    }
                }
                map[j + 1][j] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}
