package com.til.algorithm.programmers.weekly;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by Youn on 2022/06/18.
 * Title : 전력망을 둘로 나누기 (https://programmers.co.kr/learn/courses/30/lessons/86971)
 * Hint  :
 */
public class LV2_전력망을둘로나누기 {
    public int answer = Integer.MAX_VALUE;
    public ArrayList<Integer>[] adjList;

    public int solution(int n, int[][] wires) {
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];

            adjList[from].add(to);
            adjList[to].add(from);
        }

        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];

            answer = Math.min(answer, bfs(n, from, to));
        }
        return answer;
    }

    public int bfs(int n, int start, int end) {
        boolean[] visited = new boolean[n + 1];
        int count = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            int now = queue.poll();

            for (int adj : adjList[now]) {
                if (!visited[adj] && adj != end) {
                    queue.offer(adj);
                    visited[adj] = true;
                    count += 1;
                }
            }
        }
        return Math.abs(n - (2 * count));
    }
}
