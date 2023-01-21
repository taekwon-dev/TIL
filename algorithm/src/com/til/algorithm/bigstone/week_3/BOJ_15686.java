package com.til.algorithm.bigstone.week_3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686 {

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
    private static boolean[] open;
    private static List<Node> homes = new ArrayList<>();
    private static List<Node> chickens = new ArrayList<>();
    private static int min = Integer.MAX_VALUE;

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
                    homes.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    chickens.add(new Node(i, j));
                }
            }
        }
        open = new boolean[chickens.size()];

        backtracking(0, 0);
        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int index) {
        if (depth == M) {
            // 치킨 집 M개를 고르고, 도시의 치킨 거리의 최솟값 구하기
            min = Math.min(min, getChickenDistance());
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

    private static int getChickenDistance() {
        int totalChickenDistance = 0;
        for (Node home : homes) {
            int eachChickenDistance = Integer.MAX_VALUE;
            for (int i = 0; i < chickens.size(); i++) {
                if (!open[i]) {
                    continue;
                }
                eachChickenDistance = Math.min(eachChickenDistance, chickenDistance(home, chickens.get(i)));
            }
            totalChickenDistance += eachChickenDistance;
        }
        return totalChickenDistance;
    }

    private static int chickenDistance(Node home, Node chicken) {
        return Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y);
    }
}