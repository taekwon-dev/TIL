package com.til.algorithm.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  LCA (Lowest Common Ancestor) : 최소 공통 조상
 *
 *  두 노드의 공통 조상 중에서 가장 가까운 조상을 찾는 문제 (= 최소 공통 조상)
 *
 *  모든 노드에 대한 깊이를 계산한다.
 *  최소 공통 조상을 찾을 두 노드를 확인한다.
 *      - 먼저 두 노드의 깊이가 동일하도록 거슬러 올라간다.
 *      - 이후에 부모가 같아질 떄까지 반복적으로 두 노드의 부모 방향으로 거슬러 올라간다.
 *  ahems LCA(a,b) 연산에 대하여 2번의 과정을 반복한다.
 *
 *  N(2 ≤ N ≤ 50,000)개의 정점으로 이루어진 트리
 *  트리의 각 정점은 1번부터 N번까지 번호가 매겨져 있으며, 루트는 1번이다
 *  두 노드의 쌍 M(1 ≤ M ≤ 10,000)개 (간선)
 *
 *  DFS - 인접 리스트 - O (N * M) = O (50,000 * 10,000) = 500,000,000
 */
public class BOJ_11437 {
    static int n;
    static int[] depth, parent;
    static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        depth = new int[n + 1];
        parent = new int[n + 1];
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            // 무방향 그래프
            adjList[from].add(to);
            adjList[to].add(from);
        }

        init(1, 1, 0); // 루트 1, 높이 1로 설정

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

    private static void init(int curr, int height, int pa) {
        depth[curr] = height;
        parent[curr] = pa;
        for (int adj : adjList[curr]) {
            if (adj != pa) {
                init(adj, height + 1, curr);
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
        while (bh > ah) {
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
