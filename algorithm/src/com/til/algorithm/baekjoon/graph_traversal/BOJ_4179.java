package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179 {

    private static int R;
    private static int C;
    private static char[][] map;
    private static int[][] fireMap;
    private static int[][] personMap;
    private static Queue<int[]> fireQ = new LinkedList<>();
    private static Queue<int[]> personQ = new LinkedList<>();
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        fireMap = new int[R][C];
        personMap = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(fireMap[i], -1);
            Arrays.fill(personMap[i], -1);
        }

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = row.charAt(j);
                if (map[i][j] == 'F') {
                    fireMap[i][j] = 0;
                    fireQ.offer(new int[]{i, j});
                    continue;
                }
                if (map[i][j] == 'J') {
                    personMap[i][j] = 0;
                    personQ.offer(new int[]{i, j});
                }
            }
        }
        fire();
        int result = person();
        if (result == -1) {
            bw.write("IMPOSSIBLE" + "\n");
        } else {
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void fire() {
        while (!fireQ.isEmpty()) {
            int[] fire = fireQ.poll();

            for (int i = 0; i < 4; i++) {
                int nx = fire[0] + dx[i];
                int ny = fire[1] + dy[i];

                if (!validateRange(nx, ny)) {
                    continue;
                }
                if (map[nx][ny] == '#' || fireMap[nx][ny] != -1) {
                    continue;
                }
                fireQ.offer(new int[]{nx, ny});
                fireMap[nx][ny] = fireMap[fire[0]][fire[1]] + 1;
            }
        }
    }

    private static int person() {
        while (!personQ.isEmpty()) {
            int[] person = personQ.poll();

            if (isOnEdge(person[0], person[1])) {
                return personMap[person[0]][person[1]] + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = person[0] + dx[i];
                int ny = person[1] + dy[i];

                if (!validateRange(nx, ny)) {
                    continue;
                }
                if (map[nx][ny] == '#' || personMap[nx][ny] != -1) {
                    continue;
                }
                if (fireMap[nx][ny] == -1 || fireMap[nx][ny] > personMap[person[0]][person[1]] + 1) {
                    personQ.offer(new int[]{nx, ny});
                    personMap[nx][ny] = personMap[person[0]][person[1]] + 1;
                }
            }
        }
        return -1;
    }

    private static boolean validateRange(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }

    private static boolean isOnEdge(int x, int y) {
        return x == 0 || y == 0 || x == R - 1 || y == C - 1;
    }
}