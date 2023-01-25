package com.til.algorithm.bigstone.hidden_1.graph_traversal;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  이분 그래프 (Bipartite Graph) :
 *  인접한 정점끼리 서로 다른 색으로 칠해서 모든 정점을 두 가지 색으로만 칠할 수 있는 그래프
 */
public class BOJ_1707 {

    private static int K;
    private static int V;
    private static int E;
    private static boolean isBipartite;
    private static int[] color;
    private static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            color = new int[V + 1];
            adjList = new ArrayList[V + 1];

            for (int i = 1; i <= V; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjList[from].add(to);
                adjList[to].add(from);
            }
            isBipartite = true;
            bfs();
            if (isBipartite) {
                bw.write("YES" + "\n");
            } else {
                bw.write("NO" + "\n");
            }
            bw.flush();
        }
        bw.close();
        br.close();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= V; i++) {
            if (color[i] == 0) {
                queue.offer(i);
                color[i] = 1;

                while (!queue.isEmpty() && isBipartite) {
                    int now = queue.poll();
                    for (int adj : adjList[now]) {
                        if (color[adj] == 0) {
                            queue.offer(adj);
                            color[adj] = color[now] * -1;
                            continue;
                        }
                        if (color[adj] == color[now]) {
                            isBipartite = false;
                        }
                    }
                }
            }
        }
    }
}
