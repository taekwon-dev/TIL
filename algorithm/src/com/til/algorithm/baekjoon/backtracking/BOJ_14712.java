package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  - 2 X 2 단위 씩 검사하기
 *  - 전반적인 문제 해결 방향 시뮬레이션 돌려보기
 */
public class BOJ_14712 {

    private static int N;
    private static int M;
    private static boolean[][] map;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        backtracking(0, 0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int x, int y) {
        if (x == N) {
            for (int i = 0; i <= N - 2; i++) {
                for (int j = 0; j <= M - 2; j++) {
                    if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                        return;
                    }
                }
            }
            answer++;
            return;
        }
        int ny = (y + 1 == M) ? 0 : y + 1;
        int nx = (ny == 0) ? x + 1 : x;

        map[x][y] = true;
        backtracking(nx, ny);
        map[x][y] = false;

        backtracking(nx, ny);
    }
}
