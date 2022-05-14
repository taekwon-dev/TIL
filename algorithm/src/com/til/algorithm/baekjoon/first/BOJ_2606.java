package com.til.algorithm.baekjoon.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/04.
 * Title : 바이러스 (https://www.acmicpc.net/problem/2606)
 * Hint  : N (= 컴퓨터 수), 1번 컴퓨터가 바이러스에 걸렸을 때 → (N >= 1)
 *
 */
public class BOJ_2606 {

    static int n;
    static int m;
    static int count;

    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = 1;
            map[end][start] = 1;
        }

        System.out.println(dfs(1));
    }

    private static int dfs(int start) {
        visited[start] = true;

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i] && map[start][i] == 1) {
                dfs(i);
                count++;
            }
        }
        return count;
    }
}
