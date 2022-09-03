package com.til.algorithm.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 *  가장 가까운 공통 조상 (LCA) + 루트가 있는 트리에서 루트 노드 구하기
 */
public class BOJ_3584 {
    static List<Integer>[] adjList;
    static int[] parent;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            parent = new int[n + 1];
            depth = new int[n + 1];
            adjList = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                adjList[i] = new ArrayList<>();
            }
            boolean[] rooted = new boolean[n + 1];
            Arrays.fill(rooted, true);
            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjList[from].add(to);
                rooted[to] = false;
            }
            int rootIdx = 0;
            for (int i = 1; i <= n; i++) {
                if (rooted[i]) {
                    rootIdx = i;
                    break;
                }
            }
            init(rootIdx, 1, 0);
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b) + "\n");
        }
        System.out.println(sb.toString());
    }

    private static void init(int curr, int h, int pa) {
        depth[curr] = h;
        parent[curr] = pa;
        for (int child : adjList[curr]) {
            init(child, h + 1, curr);
        }
    }

    private static int lca(int a, int b) {
        int ah = depth[a];
        int bh = depth[b];

        while (ah > bh) {
            a = parent[a];
            ah--;
        }

        while (ah < bh) {
            b = parent[b];
            bh--;
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
}
