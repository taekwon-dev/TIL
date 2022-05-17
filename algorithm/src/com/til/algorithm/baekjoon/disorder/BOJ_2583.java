package com.til.algorithm.baekjoon.disorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/05.
 * Title : 영역 구하기 (https://www.acmicpc.net/problem/2583)
 * Hint  : 주어진 직사각형 꼭짓점을 통해서 직사각형에 포함된 노드와 포함되지 않은 노드를 분리한다.
 *         좌표 개념
 */
public class BOJ_2583 {

    static int m; // 세로
    static int n; // 가로
    static int k; // 직사각형 개수

    static int[][] map;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];

        k = Integer.parseInt(st.nextToken());

        // 주어진 직사각형 개수 만큼 반복
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            // 직사각형 왼쪽 아래 꼭짓점 좌표
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            // 직사각형 오른쪽 위에 꼭짓점 좌표
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = 1;
                }
            }
        }
        List<Integer> areas = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    count = 0;
                    dfs(i, j);
                    areas.add(count);
                }
            }
        }

        System.out.println(areas.size());
        Collections.sort(areas);
        for (Integer area : areas) {
            System.out.print(area +  " ");
        }
    }

    private static void dfs(int y, int x) {
        map[y][x] = 1;
        count++;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (map[ny][nx] == 0) {
                    dfs(ny, nx);
                }
            }
        }
    }
}
