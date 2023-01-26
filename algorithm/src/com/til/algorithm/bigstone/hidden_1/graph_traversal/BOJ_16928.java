package com.til.algorithm.bigstone.hidden_1.graph_traversal;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928 {

    static class Node {
        int x;
        int count;

        public Node(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }

    private static int[] dice = {1, 2, 3, 4, 5, 6};
    private static boolean[] visited = new boolean[101];
    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.put(x, y);
        }

        bw.write(bfs(1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == 100) {
                return node.count;
            }

            for (int i = 0; i < dice.length; i++) {
                int nx = node.x + dice[i];

                if (nx > 100) {
                    continue;
                }
                if (visited[nx]) {
                    continue;
                }

                if (!map.containsKey(nx)) {
                    queue.offer(new Node(nx, node.count + 1));
                    visited[nx] = true;
                    continue;
                }

                if (map.containsKey(nx) && !visited[map.get(nx)]) {
                    queue.offer(new Node(map.get(nx), node.count + 1));
                    visited[nx] = true;
                }
            }
        }
        return -1;
    }
}