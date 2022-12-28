package com.til.algorithm.baekjoon.bigstone.week_2;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10709 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int h;
    private static int w;
    private static int[][] cloud;
    private static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        cloud = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(cloud[i], -1);
        }
        for (int i = 0; i < h; i++) {
            String row = br.readLine();
            for (int j = 0; j < w; j++) {
                char c = row.charAt(j);
                if (c == 'c') {
                    cloud[i][j] = 0;
                    queue.add(new Node(i, j));
                }
            }
        }
        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sb.append(cloud[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int nx = node.x;
            int ny = node.y + 1;

            if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                if (cloud[nx][ny] == -1) {
                    queue.add(new Node(nx, ny));
                    cloud[nx][ny] = cloud[node.x][node.y] + 1;
                }
            }
        }
    }
}