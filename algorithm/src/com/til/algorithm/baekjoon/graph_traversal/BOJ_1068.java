package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1068 {

    static int n;
    static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
                continue;
            }
            // i (= 인덱스, 자식 노드)
            adjList[parent].add(i);
        }

        int remove = Integer.parseInt(br.readLine());
        removeNode(remove);
        if (remove == root) {
            System.out.println(0);
        } else {
            System.out.println(countLeafNodes(root));
        }
    }

    private static void removeNode(int target) {
        // 삭제할 자식노드가 1개 이상 있는 경우
        if (adjList[target].size() > 0) {
            int size = adjList[target].size();
            while (size > 0) {
                int child = adjList[target].get(--size);
                removeNode(child);
            }
        }

        for (int i = 0; i < n; i++) {
            if (adjList[i].contains(target)) {
                for (int j = 0; j < adjList[i].size(); j++) {
                    if (adjList[i].get(j) == target) {
                        adjList[i].remove(j);
                    }
                }
            }
        }
    }

    private static int countLeafNodes(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (adjList[node].size() == 0) {
                count++;
                continue;
            }
            for (int adj : adjList[node]) {
                queue.add(adj);
            }
        }
        return count;
    }


}
