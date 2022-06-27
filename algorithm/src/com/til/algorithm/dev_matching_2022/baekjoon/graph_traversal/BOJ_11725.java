package com.til.algorithm.dev_matching_2022.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/27.
 * Title : 트리의 부모 찾기 (https://www.acmicpc.net/problem/11725)
 * Hint  : 1번 (루트), 2번 부터 각 정점의 부모 노드 출력하기
 */
public class BOJ_11725 {

    /**
     *  정점 수 만큼의 배열 (1번 인덱스부터)에 저장한 뒤 순차적으로 출력
     *
     *  예)
     *
     *  1번 -> 6번 : 6번 인덱스에 1 저장
     *  1번 -> 4번 : 4번 인덱스에 1 저장
     *
     */

    static int n;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int[] results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        results = new int[n + 1];
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        // n - 1 개의 간선
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }

        bfs(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(results[i]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int adj : adjList[now]) {
                // adj = 해당 인덱스에 now (부모) 지정
                if (!visited[adj]) {
                    results[adj] = now;
                    queue.offer(adj);
                    visited[adj] = true;
                }
            }
        }
    }

}
