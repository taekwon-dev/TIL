package com.til.algorithm.programmers.kit.graph;

public class LV3_순위 {

    /**
     *  최단거리 알고리즘 - 플로이드 워셜 ( 노드의 수 100 이하)
     *  N 명의 선수가 있을 때 각 선수는 N - 1 번의 승패를 알 수 있어야 순위를 확정지을 수 있다.
     *
     */

    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] map = new int[n + 1][n + 1];

        for (int i = 0; i < results.length; i++) {
            int win = results[i][0];
            int lose = results[i][1];

            map[win][lose] = 1;
            map[lose][win] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1;
                        map[j][i] = -1;
                    }

                    if (map[i][k] == -1 && map[k][j] == -1) {
                        map[i][j] = -1;
                        map[j][i] = 1;
                    }
                }
            }
        }

        // 각 행 (또는 열) 별로 1 또는 - 1 의 개수가 n - 1 인 경우의 수 확인
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (map[i][j] != 0) {
                    count += 1;
                }
            }
            if (count == n - 1) {
                answer += 1;
            }
        }
        return answer;
    }
}
