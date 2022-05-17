package com.til.algorithm.baekjoon.disorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/13.
 * Title : 사회망 서비스(SNS) (https://www.acmicpc.net/problem/2533)
 * Hint  :
 *         인접 행렬 표기 방식 (그래프)
 *         "사회망 서비스에 속한 사람(정점)들은 얼리 어답터, ~얼리 어답터 중 하나다"
 *         1) 정점이 얼리어답터인 경우 → 인접 노드가 모두 얼리 어답터이어야 한다.
 *         2) 정점이 얼리어답터가 아닌 경우 → 인접 노드는 얼리 어답터 또는 ~얼리 어답터 중 아무 상태여도 상관 없다. (단, 이 경우 얼리 어답터의 수 최소 조건)
 */
public class BOJ_2533 {
    static int n;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dp = new int[n + 1][2];

        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        // N -1 만큼
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void dfs(int curr) {
        visited[curr] = true;
        dp[curr][0] = 0;
        dp[curr][1] = 1;

        for (int adjV : graph[curr]) {
            if (!visited[adjV]) {
                dfs(adjV);
                dp[curr][0] += dp[adjV][1];
                dp[curr][1] += Math.min(dp[adjV][0], dp[adjV][1]);
            }
        }
    }
}
