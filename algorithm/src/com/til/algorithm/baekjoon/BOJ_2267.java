package com.til.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2267 {

    static int node[][];
    static int visited[][];
    static int count;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫번째줄 = 이차원 배열 사이즈 N
        int n = Integer.parseInt(br.readLine());
        node = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                node[i][j] = row.charAt(j) - '0';
            }
        }


        for (int i = 0; i < node.length; i++) {
            for (int j = 0; j < node[i].length; j++) {
                if (node[i][j] == 1 && visited[i][j] == 0) {
                    count = 1;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }

    private static void dfs(int x, int y) {
        // 주어진 파라미터 좌표 = 방문한 좌표 값이므로 방문 처리
        visited[x][y] = 1;

        // →
        if (y < node.length - 1 && node[x][y+1] == 1 && visited[x][y+1] == 0) {
            count++;
            dfs(x, y+1);
        }
        // ←
        if (y > 0 && node[x][y-1] == 1 && visited[x][y-1] == 0) {
            count++;
            dfs(x, y-1);
        }
        // ↑
        if (x > 0 && node[x-1][y] == 1 && visited[x-1][y] == 0) {
            count++;
            dfs(x-1, y);
        }
        // ↓
        if (x < node.length - 1 && node[x+1][y] == 1 && visited[x+1][y] == 0) {
            count++;
            dfs(x+1, y+1);
        }
    }

}
