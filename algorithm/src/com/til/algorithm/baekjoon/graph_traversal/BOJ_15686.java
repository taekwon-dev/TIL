package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686 {

    private static int N;
    private static int M;
    private static int[][] map;
    private static ArrayList<int[]> homes = new ArrayList<>();
    private static ArrayList<int[]> chickens = new ArrayList<>();
    private static boolean[] open;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    homes.add(new int[]{i, j});
                    continue;
                }
                if (map[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }
        open = new boolean[chickens.size()];
        backtracking(0, 0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int index) {
        if (depth == M) {
            answer = Math.min(answer, getChickenMinDistance());
            return;
        }
        for (int i = index; i < chickens.size(); i++) {
            if (!open[i]) {
                open[i] = true;
                backtracking(depth + 1, i + 1);
                open[i] = false;
            }
        }
    }

    private static int getChickenMinDistance() {
        int chickenMinDistance = 0;
        for (int[] home : homes) {
            int chickenDistance = Integer.MAX_VALUE;
            int hx = home[0];
            int hy = home[1];
            for (int i = 0; i < chickens.size(); i++) {
                if (!open[i]) {
                    continue;
                }
                int cx = chickens.get(i)[0];
                int cy = chickens.get(i)[1];
                if (chickenDistance > (Math.abs(hx - cx) + Math.abs(hy - cy))) {
                    chickenDistance = Math.abs(hx - cx) + Math.abs(hy - cy);
                }
            }
            chickenMinDistance += chickenDistance;
        }
        return chickenMinDistance;
    }
}