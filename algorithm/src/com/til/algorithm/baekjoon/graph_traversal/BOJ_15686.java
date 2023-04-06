package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.ArrayList;
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
    private static boolean[] open;
    private static ArrayList<Node> homes = new ArrayList<>();
    private static ArrayList<Node> chickens = new ArrayList<>();
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    homes.add(new Node(i, j));
                    continue;
                }
                if (val == 2) {
                    chickens.add(new Node(i, j));
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
            answer = Math.min(answer, getTotalChickenDistance());
            return;
        }
        for (int i = index; i < chickens.size(); i++) {
            open[i] = true;
            backtracking(depth + 1, i + 1);
            open[i] = false;
        }
    }

    private static int getTotalChickenDistance() {
        int totalDistance = 0;
        for (Node home : homes) {
            int chickenDistance = 100;
            for (int i = 0; i < chickens.size(); i++) {
                if (!open[i]) {
                    continue;
                }
                chickenDistance = Math.min(chickenDistance, getChickenDistance(home, chickens.get(i)));
            }
            totalDistance += chickenDistance;
        }
        return totalDistance;
    }

    private static int getChickenDistance(Node home, Node chicken) {
        return Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y);
    }
}