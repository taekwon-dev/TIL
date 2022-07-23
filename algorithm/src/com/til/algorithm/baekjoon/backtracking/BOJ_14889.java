package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  스타트와 링크
 *
 *  축구를 하기 위해 모인 사람은 총 N명이고 신기하게도 N은 짝수이다.
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
 *  1, 2 / 3, 4 = 전력 차1
 *  1, 3 / 2, 4 = 전력 차2
 *  1, 4 / 2, 3 = 전력 차3
 *  -------------------- -> 대칭
 *  2, 3 / 1, 4 = 전력 차4
 *  2, 4 / 1, 3 = 전력 차5
 *  3, 4 / 1, 2 = 전력 차6
 *
 *  스타트 팀 배열
 *
 *
 *  첫번째 생각
 *  [1] [2] [3] [4] [5] [6]
 *
 *  [1] & [6]
 *  [2] & [5]
 *  [3] & [4]
 *
 *  한 팀의 배열에서 위 대칭성을 활용해서 전력 차를 구할 수 있다.
 *
 *  두번쨰 생각
 *
 *  대칭 되기 때문에 굳이 대칭되는 부부을 구할 필요가 없다.
 *  즉 1 , 2 , 3 , 4 가 있다고 했을 떄
 *  1 2 - 2 1 을 또 선택할 필요가 없으므로
 *  뽑은 노드보다 항상 더 큰 노드 중에 골라서 팀을 고르면 중복 없이 한 팀을 구성할 수 있다.
 *
 *
 */
public class BOJ_14889 {
    static int n, min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];

        StringTokenizer st;
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
            // 팀 전력 차이 계산 (최솟값 업데이트)
            // 단, 두 팀의 전력차가 0인 경우 바로 0 출력하고 프로그램 종료 가능
            // 방문 여부 배열에서 true 로 선택된 팀을 스타트로 가정한다.
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
