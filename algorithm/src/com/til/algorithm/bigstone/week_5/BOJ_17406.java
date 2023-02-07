package com.til.algorithm.bigstone.week_5;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17406 {

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
            rotate();
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

    private static void rotate() {
        int[][] tmp = copy();
        for (int i = 0; i < K; i++) {
            int R = rotate[arr[i]][0];
            int C = rotate[arr[i]][1];
            int S = rotate[arr[i]][2];

            for (int s = 1; s <= S; s++) {
                int rightTmp = tmp[R - s][C + s];
                int downTmp = tmp[R + s][C + s];
                int leftTmp = tmp[R + s][C - s];

                for (int y = C + s; y > C - s; y--) {
                    tmp[R - s][y] = tmp[R - s][y - 1];
                }

                for (int x = R + s; x > R - s; x--) {
                    tmp[x][C + s] = tmp[x - 1][C + s];
                }
                tmp[R - s + 1][C + s] = rightTmp;

                for (int y = C - s; y < C + s; y++) {
                    tmp[R + s][y] = tmp[R + s][y + 1];
                }
                tmp[R + s][C + s - 1] = downTmp;

                for (int x = R - s; x < R + s; x++) {
                    tmp[x][C - s] = tmp[x + 1][C - s];
                }
                tmp[R + s - 1][C - s] = leftTmp;
            }
        }
        findMin(tmp);

    }

    private static int[][] copy() {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        return tmp;
    }

    private static void findMin(int[][] tmp) {
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += tmp[i][j];
            }
            if (answer > sum) {
                answer = sum;
            }
        }
    }
}
