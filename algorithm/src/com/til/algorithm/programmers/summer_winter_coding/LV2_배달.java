package com.til.algorithm.programmers.summer_winter_coding;

public class LV2_배달 {

    private int INF = (int) 1e9;

    public int solution(int N, int[][] road, int K) {
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = INF;
                if (i == j) {
                    map[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < road.length; i++) {
            int from = road[i][0];
            int to = road[i][1];
            int cost = road[i][2];
            if (map[from][to] > cost) {
                map[from][to] = cost;
                map[to][from] = cost;
            }
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (map[1][i] <= K) {
                answer++;
            }
        }
        return answer;
    }
}