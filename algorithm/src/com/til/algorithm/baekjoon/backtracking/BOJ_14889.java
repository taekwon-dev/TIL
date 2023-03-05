package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14889 {

    private static int N;
    private static int[][] map;
    private static boolean[] visited;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtracking(0, 0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int index) {
        if (depth == N / 2) {
            answer = Math.min(answer, findMin());
            return;
        }
        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    // 6명 이상 부터는 2명씩 짝을 지는 것이 아니라서 아래 코드 이해가 직관적으로 안되는 경우가 있는데,
    // 결국 (i, j) 쌍으로 두 사람이 한 팀이 됐을 때 얻을 수 있는 시너지 값을 더해가는 것을 중심으로 생각해보면 이해가 될 것.
    private static int findMin() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    start += map[i][j] + map[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += map[i][j] + map[j][i];
                }
            }
        }
        return Math.abs(start - link);
    }
}