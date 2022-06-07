package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/06.
 * Title : 점프 점프 (https://www.acmicpc.net/problem/14248)
 * Hint  : DFS 내 종료 조건을 수행하는 횟수로 고정시키지 말자
 */
public class BOJ_14248_DFS {

    static int n, s;
    static int[] stones;
    static int[] dirs = {-1, 1};
    static boolean[] visited;
    static int result = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        stones = new int[n + 1];
        visited = new boolean[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }
        s = Integer.parseInt(br.readLine());

        dfs(s);
        System.out.println(result);
    }

    private static void dfs(int start) {
        visited[start] = true;

        for (int dir : dirs) {
            int next = dir * stones[start] + start;

            if ((next >= 1 && next <= n) && !visited[start]) {
                result++;
                dfs(next);
            }

        }
    }

}
