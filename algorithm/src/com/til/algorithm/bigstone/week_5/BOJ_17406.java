package com.til.algorithm.bigstone.week_5;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17406 {

    private static int N;
    private static int M;
    private static int K;
    private static int[][] map;
    private static int[][] rotation;
    private static int[] order;
    private static boolean[] visited;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        rotation = new int[K][3];
        order = new int[K];
        visited = new boolean[K];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            rotation[i][0] = Integer.parseInt(st.nextToken()) - 1;
            rotation[i][1] = Integer.parseInt(st.nextToken()) - 1;
            rotation[i][2] = Integer.parseInt(st.nextToken());
        }
        backtracking(0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth) {
        if (depth == K) {
            int[][] copy = new int[N][M];
            for (int i = 0; i < N; i++) {
                copy[i] = map[i].clone();
            }
            findMin(copy);
            return;
        }
        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                order[depth] = i;
                visited[i] = true;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void findMin(int[][] copy) {
        for (int i = 0; i < K; i++) {
            int lx = rotation[order[i]][0] - rotation[order[i]][2];
            int ly = rotation[order[i]][1] - rotation[order[i]][2];
            int rx = rotation[order[i]][0] + rotation[order[i]][2];
            int ry = rotation[order[i]][1] + rotation[order[i]][2];
            rotate(copy, lx, ly, rx, ry);
        }
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += copy[i][j];
            }
            if (answer > sum) {
                answer = sum;
            }
        }
    }

    private static void rotate(int[][] copy, int lx, int ly, int rx, int ry) {
        if (lx == rx && ly == ry) {
            return;
        }
        int rightTemp = copy[lx][ry];
        int downTemp = copy[rx][ry];
        int leftTemp = copy[rx][ly];

        for (int i = ry; i > ly; i--) {
            copy[lx][i] = copy[lx][i - 1];
        }
        for (int i = rx; i > lx; i--) {
            if (i == lx + 1) {
                copy[i][ry] = rightTemp;
                continue;
            }
            copy[i][ry] = copy[i - 1][ry];
        }
        for (int i = ly; i < ry; i++) {
            if (i == ry - 1) {
                copy[rx][i] = downTemp;
                continue;
            }
            copy[rx][i] = copy[rx][i + 1];
        }
        for (int i = lx; i < rx; i++) {
            if (i == rx - 1) {
                copy[i][ly] = leftTemp;
                continue;
            }
            copy[i][ly] = copy[i + 1][ly];
        }
        rotate(copy, lx + 1, ly + 1, rx - 1, ry - 1);
    }
}