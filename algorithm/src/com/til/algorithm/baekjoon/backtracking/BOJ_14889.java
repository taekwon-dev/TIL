package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  스타트와 링크
 *
 *  축구를 하기 위해 모인 사람은 총 N명이고 신기하게도 N은 짝수이다. N(4 ≤ N ≤ 20, N은 짝수)
 *  제 N/2명으로 이루어진 스타트 팀과 링크 팀으로 사람들을 나눠야 한다.
 *
 *  Sij = i, j 가 같은 팀에 속했을 떄 팀에 더해지는 능력치 (Sij 와 Sji 는 다를 수도 있다)
 *  i, j 가 같은 팀에 속하는 경우 팀에 더해지는 능력치 = Sij + Sji
 *  팀의 능력치 = 팀에 속한 모든 쌍의 능력치 Sij의 합
 *
 *  두 팀 -> 스타트 VS 링크
 *  첫째 줄에 스타트 팀과 링크 팀의 능력치의 차이의 최솟값 구하기
 *
 *  1. 팀 구성
 *  2. 두 팀의 전력 차이를 게산
 *  3. 최솟값 업데이트
 *
 *  4명 ( 1, 2, 3, 4 )
 *
 *  4C2 = 6 가지 경우의 수
 *
 *  2 / 2
 *  [스타트] [링크]
 *  1, 2 / 3, 4 = 전력 차
 *  1, 3 / 2, 4 = 전력 차
 *  1, 4 / 2, 3 = 전력 차
 *  -------------------- -> 대칭 (아래는 중복, 주어진 범위 내에서 선택과 ~선택으로 나뉘므로)
 *  2, 3 / 1, 4 = 전력 차
 *  2, 4 / 1, 3 = 전력 차
 *  3, 4 / 1, 2 = 전력 차
 *
 *  한 팀을 기준으로, 4명 중 2명을 선택할 경우의 수 = 6
 *  2명 선택 시 마다 능력 치를 배치 (6 사이즈 배열, 아래 각 원소는 2명의 능력치 값)
 *  | | | | | |
 *  ↑         ↑
 *
 *  | | | | | |
 *    ↑     ↑
 *
 *  | | | | | |
 *      ↑ ↑
 */
public class BOJ_14889 {
    static int n, min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtracking(0, 0);
        System.out.println(min);
    }

    private static void backtracking(int depth, int index) {
        if (depth == n / 2) {
            // N / 2 명의 선수를 뽑았을 때 해당 팀의 능력치 계산
            int start = 0;
            int link = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (visited[i] && visited[j]) {
                        start += map[i][j];
                        start += map[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        link += map[i][j];
                        link += map[j][i];
                    }
                }
            }
            min = Math.min(min, Math.abs(start - link));
            if (min == 0) {
                System.out.println(0);
                System.exit(0);
            }
            return;
        }
        for (int i = index; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

}
