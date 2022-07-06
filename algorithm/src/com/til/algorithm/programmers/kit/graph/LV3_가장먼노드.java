package com.til.algorithm.programmers.kit.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LV3_가장먼노드 {

    /**
     *  1번 노드 (시작이 고정)에서 가장 멀리 떨어진 노드의 갯수
     *  (이 때 가장 멀리 떨어진 기준 -> 최단 거리, 가중치가 모두 1로 동일, 무방향 -> BFS)
     */

    public int solution(int n, int[][] edge) {
        int answer = 0;

        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        int[] visited = new int[n + 1];

        for (int i = 0; i < edge.length; i++) {
            int from = edge[i][0];
            int to = edge[i][1];

            adjList[from].add(to);
            adjList[to].add(from);
        }

        bfs(1, adjList, visited);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, visited[i]);
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i] == max) {
                answer += 1;
            }
        }
        return answer;
    }

    private void bfs(int start, ArrayList<Integer>[] adjList, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {

            int now = queue.poll();

            for (int adj : adjList[now]) {
                if (visited[adj] == 0) {
                    queue.offer(adj);
                    visited[adj] = visited[now] + 1;
                }
            }
        }
    }
}
