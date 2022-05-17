package com.til.algorithm.baekjoon.disorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/11.
 * Title : 이분 그래프 (https://www.acmicpc.net/problem/1707)
 * Hint  : DFS
 */
public class BOJ_1707 {

    static int k;
    static int v;
    static int e;

    static List<Integer>[] graph;
    static int[] colors;

    static boolean bipartite;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < k; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph = new ArrayList[v + 1];
            colors = new int[v + 1];

            for (int i = 1; i < v + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            bipartite = true;

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                graph[start].add(end);
                graph[end].add(start);
            }

            for (int i = 1; i < v + 1; i++) {
                if (!bipartite) {
                    break;
                }
                if (colors[i] == 0) {
                    dfs(i, 1);
                }
            }
            System.out.println(bipartite ? "YES" : "NO");
        }
    }

    private static void dfs(int start, int color) {
        colors[start] = color;

        for (int adjV : graph[start]) {
            if (colors[adjV] == color) {
                bipartite = false;
                return;
            }

            if (colors[adjV] == 0) {
                dfs(adjV, -color);
            }
        }
    }
}
