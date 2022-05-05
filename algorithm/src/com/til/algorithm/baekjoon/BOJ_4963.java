package com.til.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/05.
 * Title : 섬의 개수 (https://www.acmicpc.net/problem/4963)
 * Hint  :
 */
public class BOJ_4963 {

    static int h;
    static int w;

    static int[][] map;
    static boolean[][] visited;

    static int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String row;
        StringTokenizer st;
        while (!(row = br.readLine()).equals("0 0")) {
            // 각 테스트 케이스 별로 결과 값 (= 섬 개수)를 0으로 초기화
            result = 0;
            st = new StringTokenizer(row);

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new int[h][w];
            visited = new boolean[h][w];

            // 주어진 테스트 케이스 맵 별로 땅과 바다를 표기
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    if (!visited[y][x] && map[y][x] == 1) {
                        dfs(y, x);
                        result++;
                    }
                }
            }

            System.out.println(result);
        }
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 8; i++) {

            int ny = y + dy[i];
            int nx = x + dx[i];

            // 주어진 맵 내부에서만 이동 가능
            if (ny >= 0 && nx >= 0 && ny < h && nx < w) {
                // 방문하지 않은 땅일 때만 이동 가능
               if (!visited[ny][nx] && map[ny][nx] == 1) {
                   dfs(ny, nx);
               }
            }
        }
    }
}
