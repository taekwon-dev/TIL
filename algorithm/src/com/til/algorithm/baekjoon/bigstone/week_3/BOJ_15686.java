package com.til.algorithm.baekjoon.bigstone.week_3;

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

    private static int n;
    private static int m;
    private static int[][] map;
    private static boolean[] open;
    private static List<Node> home;
    private static List<Node> chicken;
    private static int answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    home.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        answer = Integer.MAX_VALUE;
        open = new boolean[chicken.size()];

        dfs(0, 0);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int depth, int start) {
        if (depth == m) {
            int candiate = 0;
            for (int i = 0; i < home.size(); i++) {
                int tmp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (!open[j]) {
                        continue;
                    }
                    int distance = Math.abs(home.get(i).x - chicken.get(j).x)
                            + Math.abs(home.get(i).y - chicken.get(j).y);
                    tmp = Math.min(tmp, distance);
                }
                candiate += tmp;
            }
            answer = Math.min(answer, candiate);
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            dfs(depth + 1, i + 1);
            open[i] = false;
        }
    }
}