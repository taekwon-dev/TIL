package com.til.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/03.
 * Title : 알파벳 (https://www.acmicpc.net/problem/1987)
 * Hint  : 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다. (즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.)
 *         말이 최대한 몇 칸을 지날 수 있는지를 구한다. (최대)
 */
public class BOJ_1987 {

    static int map[][];

    // 대문자 앞파벳 방문 여부
    static boolean visited[];

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int r, c;
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                // 주어진 문자 -> 숫자로 변환 (이 때 아스키코드 활용)
                // A -> 0 B -> 1
                map[i][j] = row.charAt(j) - 'A';
            }
        }
        dfs(0, 0, 0);
        System.out.println(result);
    }

    private static void dfs(int x, int y, int count) {
        // 이미 방문한 알파벳인 경우 -> 종료 조건
        if (visited[map[x][y]]) {
            result = Math.max(result, count);
            return;
        } else {
            visited[map[x][y]] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = x + dy[i];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    dfs(nx, ny, count + 1);
                }
            }
            visited[map[x][y]] = false;
        }

    }

}
