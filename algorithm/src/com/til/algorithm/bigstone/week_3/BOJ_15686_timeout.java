package com.til.algorithm.bigstone.week_3;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686_timeout {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] picked;
    private static ArrayList<Node> homes = new ArrayList<>();
    private static ArrayList<Node> chickens = new ArrayList<>();
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        picked = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    homes.add(new Node(i, j));
                }
            }
        }
        backtracking(0);
        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth) {
        if (depth == M) {
            // 치킨 집 M개 고르고, 치킨 거리의 최솟값 계산
            min = Math.min(min, chickenDistance());
            return;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!picked[i][j] && map[i][j] == 2) {
                    chickens.add(new Node(i, j));
                    picked[i][j] = true;
                    backtracking(depth + 1);
                    chickens.remove(chickens.size() - 1);
                    picked[i][j] = false;
                }
            }
        }
    }

    private static int chickenDistance() {
        int minChickenDistance = 0;
        for (Node home : homes) {
            int chickenDistance = Integer.MAX_VALUE;
            for (Node chicken : chickens) {
                chickenDistance = Math.min(chickenDistance, Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y));
            }
            minChickenDistance += chickenDistance;
        }
        return minChickenDistance;
    }
}