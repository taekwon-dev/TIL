package com.til.algorithm.baekjoon.simulation;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686 {

    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[] open;
    private static ArrayList<int[]> chickens;
    private static ArrayList<int[]> homes;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        chickens = new ArrayList<>();
        homes = new ArrayList<>();
        answer = Integer.MAX_VALUE;

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
            open[i] = true;
            backtracking(depth + 1, i + 1);
            open[i] = false;
        }
    }

    private static int getTotalChickenDistance() {
        int totalChickenDistance = 0;
        for (int i = 0; i < homes.size(); i++) {
            int chickenDistance = Integer.MAX_VALUE;
            for (int j = 0; j < chickens.size(); j++) {
                if (!open[j]) {
                    continue;
                }
                int distance = Manhattan(homes.get(i), chickens.get(j));
                if (chickenDistance > distance) {
                    chickenDistance = distance;
                }
            }
            totalChickenDistance += chickenDistance;
        }
        return totalChickenDistance;
    }

    private static int Manhattan(int[] home, int[] chicken) {
        return Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]);
    }
}