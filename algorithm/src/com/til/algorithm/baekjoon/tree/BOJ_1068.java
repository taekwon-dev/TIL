package com.til.algorithm.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 트리
 */
public class BOJ_1068 {
    static int n;
    static List<Integer>[] adjList;
    static int delete;
    static int answer;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
                queue.add(i);
                continue;
            }
            adjList[parent].add(i);
        }
        delete = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            if (i == delete) {
                adjList[i].clear();
            }
        }
        bfs();

        if (root == delete) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }

    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            if (parent != delete) {
                if (adjList[parent].size() == 0) {
                    answer++;
                    continue;
                } else if (adjList[parent].size() == 1 && adjList[parent].contains(delete)) {
                    answer++;
                    continue;
                }
                for (int child : adjList[parent]) {
                    queue.add(child);
                }
            }
        }
    }
}
