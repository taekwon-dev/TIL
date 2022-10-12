package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3184 {
    static int r, c;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int region_o_num, region_v_num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        int result_o_num = 0, result_v_num = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && map[i][j] != '#') {
                    dfs(i, j);

                    if (region_o_num > region_v_num) {
                        region_v_num = 0;
                    } else {
                        region_o_num = 0;
                    }

                    result_o_num += region_o_num;
                    result_v_num += region_v_num;

                    region_o_num = 0;
                    region_v_num = 0;
                }
            }
        }
        System.out.println(result_o_num + " " + result_v_num);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        if (map[x][y] == 'o') {
            region_o_num++;
        } else if (map[x][y] == 'v') {
            region_v_num++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                if (!visited[nx][ny] && map[nx][ny] != '#') {
                    dfs(nx, ny);
                }
            }
        }
    }
}
