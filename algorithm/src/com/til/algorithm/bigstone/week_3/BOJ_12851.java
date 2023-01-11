package com.til.algorithm.bigstone.week_3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  BFS 를 이용한 최단거리 + 특정 위치에 최단거리로 이동할 수 있는 경우의 수
 */
public class BOJ_12851 {

    private static int N;
    private static int K;
    private static int[] dist = new int[100_001];
    private static int shortest_path = Integer.MAX_VALUE;
    private static int shortest_path_cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            bw.write(0 + "\n");
            bw.write(1 + "\n");
        } else {
            bfs(N);
            bw.write(shortest_path + "\n");
            bw.write(shortest_path_cnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        dist[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (shortest_path < dist[now]) {
                continue;
            }

            int nx = -1;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    nx = now - 1;
                } else if (i == 1) {
                    nx = now + 1;
                } else if (i == 2) {
                    nx = now * 2;
                }
            }
            if (nx == K) {
                shortest_path = dist[now];
                shortest_path_cnt++;
            }
            if (dist[nx] == 0 || dist[nx] == dist[now] + 1) {
                queue.add(nx);
                dist[nx] = dist[now] + 1;
            }
        }
    }
}