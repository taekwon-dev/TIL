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
 *  N개의 도시를 모두 거쳐 -> ☼ 중요 조건 ☼
 *  다시 원래의 도시로 돌아오는 순회 -> ☼ 중요 조건 ☼
 *
 *   단, 한 번 갔던 도시로는 다시 갈 수 없다. (맨 마지막에 여행을 출발했던 도시로 돌아오는 것은 예외)
 *   이런 여행 경로는 여러 가지가 있을 수 있는데,
 *   가장 적은 비용을 들이는 여행 계획을 세우고자 한다.
 *
 *   w[i][j] = i to j cost
 *   w[i][j] could be not same w[j][i]
 *   w[i][i] = 0
 *   w[i][j] = 0 (if there is no way)
 *
 *   1번 -> .... -> 1번
 *   2번 -> .... -> 2번
 *
 *   순회 과정에서 방문한 도시에 대해서 별도로 방문 여부 처리
 *   (단, 출발 도시는 마지막으로 도착할 때 처리)
 *
 *   다시 출발 도시로 도착한 경우 -> 최소 비용 계산
 *
 *   출발도시 1 ~ N
 *
 */
public class BOJ_10971 {
    static int n;
    static int[][] map;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        // i to j, j to i 대칭이 아니므로 2차원 배열로 표현
        map = new int[n][n];
        visited = new boolean[n + 1];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, i, 0);
        }
        System.out.println(min);
    }

    private static void dfs(int depth, int start, int prev, int cost) {
        visited[start] = true;

        if (depth == n - 1) {
            // start -> next (= 그 다음 노드의 prev)
            // prev -> next (= 그 다음 노드의 prev)
            // 결국 n - 1 번째 이동한 뒤 해당 노드에서 시작 노드까지의 연결이 되어 있는 지 확인한 뒤
            // 최소 비용 검사 적용
            if (map[prev][start] != 0) {
                min = Math.min(min, cost + map[prev][start]);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
               visited[i] = true;
               // 이동한 대상이 다시 prev 가 되고, 전역으로 start가 공유돼야 함. (각 노드를 시작으로 순회를 시작한 로직에서)
                if (map[prev][i] != 0) {
                    dfs(depth + 1, start, i, cost + map[prev][i]);
                }
               visited[i] = false;
            }
        }
    }


}
