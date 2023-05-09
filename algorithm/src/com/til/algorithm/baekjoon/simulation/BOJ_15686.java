package com.til.algorithm.baekjoon.simulation;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686 {

    private static int N;
    private static int M;
    private static int[][] map;
    private static ArrayList<int[]> chickens;
    private static ArrayList<int[]> homes;
    private static boolean[] open;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        answer = Integer.MAX_VALUE;
        chickens = new ArrayList<>();
        homes = new ArrayList<>();

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

    private static void backtracking(int depth, int start) {
        if (depth == M) {
            answer = Math.min(answer, getTotalChickenDistance());
            return;
        }
        for (int i = start; i < open.length; i++) {
            if (!open[i]) {
                open[i] = true;
                backtracking(depth + 1, i + 1);
                open[i] = false;
            }
        }
    }

    private static int getTotalChickenDistance() {
        int totalChickenDistance = 0;
        for (int[] home : homes) {
            int chickenDistance = Integer.MAX_VALUE;
            for (int i = 0; i < chickens.size(); i++) {
                if (!open[i]) {
                    continue;
                }
                if (chickenDistance > Math.abs(home[0] - chickens.get(i)[0]) + Math.abs(home[1] - chickens.get(i)[1])) {
                    chickenDistance = Math.abs(home[0] - chickens.get(i)[0]) + Math.abs(home[1] - chickens.get(i)[1]);
                }
            }
            totalChickenDistance += chickenDistance;
        }
        return totalChickenDistance;
    }
}