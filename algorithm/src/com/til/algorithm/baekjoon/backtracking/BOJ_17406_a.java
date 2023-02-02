package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17406_a {

    private static int N;
    private static int M;
    private static int K;
    private static int[] arr;
    private static boolean[] visited;
    private static int[][] map;
    private static int[][] rotate;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[K];
        visited = new boolean[K];
        map = new int[N][M];
        rotate = new int[K][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            rotate[k][0] = Integer.parseInt(st.nextToken()) - 1;
            rotate[k][1] = Integer.parseInt(st.nextToken()) - 1;
            rotate[k][2] = Integer.parseInt(st.nextToken());
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
                for (int j = 0; j < M; j++) {
                    copy[i][j] = map[i][j];
                }
            }
            findMin(copy);
            return;
        }
        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                arr[depth] = i;
                visited[i] = true;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void findMin(int[][] copy) {
        for (int i = 0; i < arr.length; i++) {
            int lx = rotate[arr[i]][0] - rotate[arr[i]][2];
            int ly = rotate[arr[i]][1] - rotate[arr[i]][2];
            int rx = rotate[arr[i]][0] + rotate[arr[i]][2];
            int ry = rotate[arr[i]][1] + rotate[arr[i]][2];
            rotate(lx, ly, rx, ry, copy);
        }
        for (int i = 0; i < N; i++) {
            int min = 0;
            for (int j = 0; j < M; j++) {
                min += copy[i][j];
            }
            if (answer > min) {
                answer = min;
            }
        }
    }

    private static void rotate(int lx, int ly, int rx, int ry, int[][] copy) {
        if (lx == rx && ly == ry) {
            return;
        }
        int rightTmp = copy[lx][ry];
        int downTmp = copy[rx][ry];
        int leftTmp = copy[rx][ly];

        for (int i = ry; i > ly; i--) {
            copy[lx][i] = copy[lx][i - 1];
        }
        for (int i = rx; i > lx; i--) {
            if (i == lx + 1) {
                copy[i][ry] = rightTmp;
                continue;
            }
            copy[i][ry] = copy[i - 1][ry];
        }
        for (int i = ly; i < ry; i++) {
            if (i == ry - 1) {
                copy[rx][i] = downTmp;
                continue;
            }
            copy[rx][i] = copy[rx][i + 1];
        }
        for (int i = lx; i < rx; i++) {
            if (i == rx - 1) {
                copy[i][ly] = leftTmp;
                continue;
            }
            copy[i][ly] = copy[i + 1][ly];
        }
        rotate(lx + 1, ly + 1, rx - 1, ry - 1, copy);
    }
}