package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  외판원 순회 2
 *
 *  1번부터 N번까지 번호가 매겨져 있는 도시
 *  도시들 사이에는 길이 있다. (길이 없을 수도 있다)
 *
 *  이제 한 외판원이 어느 한 도시에서 출발해 -> 1 ~ N 노드에서 각각 출발하는 경우 (완전탐색)
 *  (어느 한 도시에서 출발해 N개의 도시를 모두 거쳐 다시 원래의 도시로 돌아오는 순회 여행 경로를 계획하려고 한다)
 *  N개의 도시를 모두 거쳐 -> ☼ 중요 조건 ☼
 *  다시 원래의 도시로 돌아오는 순회 -> ☼ 중요 조건 ☼
 *
 *  단, 한 번 갔던 도시로는 다시 갈 수 없다. (맨 마지막에 여행을 출발했던 도시로 돌아오는 것은 예외)
 *  이런 여행 경로는 여러 가지가 있을 수 있는데,
 *  가장 적은 비용을 들이는 여행 계획을 세우고자 한다.
 *
 *  최소 비용
 *
 *  W[i][j] = i 도시에서 j 도시로 가지 위한 비용
 *  W[i][j] != W[j][i]
 *
 *  첫째 줄에 도시의 수 N이 주어진다. (2 ≤ N ≤ 10)
 *
 *  N -> ? -> ? -> ? -> ... -> N
 *
 *  1 -> 2 -> 3 -> 4 -> 1
 *
 *  2차원 배열로 되어 있지만, 결국 도시 기준으로 보면 1차원으로 방문 여부를 관리할 수 있다.
 */
public class BOJ_10971 {
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

        for (int i = 0; i < n; i++) {
            backtracking(0, i, i, 0);
        }
        System.out.println(min);
    }

    // N = 4
    // 1 -> 2 -> 3 -> 4 -> 1
    private static void backtracking(int depth, int start, int prev, int cost) {
        visited[start] = true;

        if (depth == n - 1) {
            // 조건부 (마지막 도시에서 출발 도시로 이동가능한 경우)
            if (map[prev][start] != 0) {
                min = Math.min(min, cost + map[prev][start]);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (map[prev][i] != 0) {
                    backtracking(depth + 1, start, i, cost + map[prev][i]);
                }
                visited[i] = false;
            }
        }

    }



}
