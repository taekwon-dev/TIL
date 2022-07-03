package com.til.algorithm.dev_matching_2022.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/28.
 * Title : 외판원 순회 (https://www.acmicpc.net/problem/10971)
 * Hint  : Traveling Salesman Problem (TSP), https://youngest-programming.tistory.com/547
 */
public class BOJ_10971 {

    /**
     *  각 정점 (도시) 간 이동 시 가중치 (비용)이 다르다.
     *  모든 도시 간 이동 시 소요되는 비용은 양의 정수다.
     *  i -> j 갈 수 없는 경우, 0으로 표기된다.
     *  i -> j 비용과 j -> i 비용은 다를 수 있다.
     *  한 번 방문한 도시는 다시 방문할 수 없다. (단, 마지막 여행을 출발 했던 도시로 돌아오는 것은 예외 -> 순회 상황)
     *  최소 비용이 드는 여행 경로를 구하는 문제
     *
     *  Brute force + Backtracking
     *  - 모든 경우를 확인하지만, 중간에 이미 최소 비용을 초과한 여행 경로는 초과 시점에 확인을 중단하고 다음 케이스로 넘어간다
     *  - 모든 경우란, 각 도시에서 출발해서 다시 출발한 도시로 돌아오는 경우
     */

    static int n;
    static int[][] map;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

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

        for (int i = 0; i < n; i++) {
            backtracking(0, i, i, 0);
        }
        System.out.println(min);
    }

    private static void backtracking(int depth, int start, int prev, int cost) {
        visited[start] = true;
        // 출발 도시 제외하고, 방문할 수 있는 도시를 모두 방문 했을 때
        if (depth == n - 1) {
            // 다시 출발 도시로 방문하는 경우 (방문 여부와 관계 없이 계산)
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
