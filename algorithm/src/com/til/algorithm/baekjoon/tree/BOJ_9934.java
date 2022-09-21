package com.til.algorithm.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 완전 이진 트리
 */
public class BOJ_9934 {
    static int[] node;
    static List<Integer>[] adjList;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        size = (int) Math.pow(2, k) - 1;
        node = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            node[i] = Integer.parseInt(st.nextToken());
        }
        adjList = new List[k];
        for (int i = 0; i < k; i++) {
            adjList[i] = new ArrayList<>();
        }
        solve(0, size - 1, 0);
        for (int i = 0; i < k; i++) {
            for (int adj : adjList[i]) {
                System.out.print(adj + " ");
            }
            System.out.println();
        }
    }

    private static void solve(int s, int e, int depth) {
        if (s > e) return;
        int mid = (s + e) / 2;
        adjList[depth].add(node[mid]);
        solve(s, mid - 1, depth + 1);
        solve(mid + 1, e, depth + 1);
    }

}
