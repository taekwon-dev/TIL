package com.til.algorithm.baekjoon.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/05.
 * Title : 연결 요소의 개수 (https://www.acmicpc.net/problem/11724)
 * Hint  :
 */
public class BOJ_11724 {

    static int n; // 정점 수
    static int m; // 간선 수

    static int[][] map;
    static boolean[] visited;

    static int result;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 각 정점의 값이 1 이상이므로 0번 인덱스를 무시할 수 있도록 +1 해서 배열방 생성
        map = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = 1;
            map[end][start] = 1;
        }

        for (int j = 1; j <= n; j++) {
            if (!visited[j]) {
                dfs(j);
                result++;
            }
        }

        System.out.println(result);
    }

    private static void dfs(int start) {
        visited[start] = true;

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && map[start][i] == 1) {
                dfs(i);
            }
        }

    }

}
