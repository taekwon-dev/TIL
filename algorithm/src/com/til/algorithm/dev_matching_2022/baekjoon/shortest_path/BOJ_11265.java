package com.til.algorithm.dev_matching_2022.baekjoon.shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/28.
 * Title : 끝나지 않는 파티 (https://www.acmicpc.net/problem/11265)
 * Hint  : 플로이드 워셜 알고리즘
 */
public class BOJ_11265 {

    /**
     * 모든 노드에서 다른 모든 노드까지의 최단 경로를 모두 계산한다.
     * 플로이드 워셜 알고리즘은 다익스트라 알고리즘과 마찬가지로 단계별로 거쳐 가는 노드를 기준으로 알고리즘을 수행한다.
     * 다만, 매 단계마다 방문하지 않는 노드 중에 최단 거리를 갖는 노드를 찾는 과정이 필요하지 않다.
     * 플로이드 워셜은 2차원 테이블에 최단 거리 정보를 저장한다.
     * 플로이드 워셜 알고리즘은 DP 유형에 속한다.
     * <p>
     * Dab = min (Dab, Dak + Dkb)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (map[from][to] <= cost) {
                System.out.println("Enjoy other party");
            } else {
                System.out.println("Stay here");
            }
        }
    }
}
