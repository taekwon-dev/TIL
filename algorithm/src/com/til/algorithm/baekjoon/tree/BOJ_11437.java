package com.til.algorithm.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * LCA 1
 */
public class BOJ_11437 {
    static List<Integer>[] adjList;
    static int[] parent;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        depth = new int[n + 1];
        adjList = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st = null;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }
        init(1, 1, 0);

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
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
            if (child != pa) {
                init(child, h + 1, curr);
            }
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
