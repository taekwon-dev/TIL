package problem_solving.baekjoon.simulation;

import java.util.*;
import java.io.*;

public class BOJ_14889 {

    private static int n;
    private static int[][] map;
    private static boolean[] visited;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        StringTokenizer st;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 1);

        System.out.println(answer);
    }

    private static void backtracking(int depth, int start) {
        if (depth == n / 2) {
            answer = Math.min(answer, minDiff());
            return;
        }
        for (int i = start; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static int minDiff() {
        int start = 0;
        int link = 0;
        for (int i = 1; i <= n - 1; i++) {
            for (int j = i + 1; j <= n; j++) {
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