package com.til.algorithm.baekjoon.disorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/05.
 * Title : 트리의 부모 찾기 (https://www.acmicpc.net/problem/11725)
 * Hint  :
 */
public class BOJ_11725 {

    static int n;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        parents = new int[n+1];
        visited = new boolean[n+1];

        for (int i = 1; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }

        // N-1 개의 간선 정보
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            // Bi, Undirected
            list[p].add(q);
            list[q].add(p);
        }

        dfs(1);
        for (int i = 2; i < n + 1; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void dfs(int start) {
        visited[start] = true;

        for (int adj : list[start]) {
            if (!visited[adj]) {
                parents[adj] = start;
                dfs(adj);
            }
        }
    }



}
