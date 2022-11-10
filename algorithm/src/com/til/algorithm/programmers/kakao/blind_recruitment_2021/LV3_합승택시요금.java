package com.til.algorithm.programmers.kakao.blind_recruitment_2021;

public class LV3_합승택시요금 {
    private final int INF = 200 * 100_001;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                map[i][j] = INF;
            }
        }

        for (int i = 0; i < fares.length; i++) {
            int from = fares[i][0];
            int to = fares[i][1];
            int cost = fares[i][2];

            map[from][to] = cost;
            map[to][from] = cost;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        int answer = map[s][a] + map[s][b];
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
        }
        return answer;
    }
}
