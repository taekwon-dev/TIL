package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427 {

    private static int M;
    private static int N;
    private static char[][] map;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static Queue<int[]> fireQ = new LinkedList<>();
    private static Queue<int[]> personQ = new LinkedList<>();
    private static int[][] fireMap;
    private static int[][] personMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            fireMap = new int[N][M];
            personMap = new int[N][M];

            for (int i = 0; i < N; i++) {
                Arrays.fill(fireMap[i], -1);
                Arrays.fill(personMap[i], -1);
            }

            for (int i = 0; i < N; i++) {
                String row = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = row.charAt(j);
                    if (map[i][j] == '*') {
                        fireQ.offer(new int[]{i, j});
                        fireMap[i][j] = 0;
                        continue;
                    }
                    if (map[i][j] == '@') {
                        personQ.offer(new int[]{i, j});
                        personMap[i][j] = 0;
                    }
                }
            }
            fire();
            int result = person();
            if (result == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
        }
    }

    private static void fire() {
        while (!fireQ.isEmpty()) {
            int[] fire = fireQ.poll();
            int fireX = fire[0];
            int fireY = fire[1];

            for (int i = 0; i < 4; i++) {
                int nx = fireX + dx[i];
                int ny = fireY + dy[i];

                if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) {
                    continue;
                }
                if (map[nx][ny] == '#' || fireMap[nx][ny] != -1) {
                    continue;
                }
                fireQ.offer(new int[]{nx, ny});
                fireMap[nx][ny] = fireMap[fireX][fireY] + 1;
            }
        }
    }

    private static int person() {
        while (!personQ.isEmpty()) {
            int[] person = personQ.poll();
            int personX = person[0];
            int personY = person[1];

            if (isOnEdge(personX, personY)) {
                return personMap[personX][personY] + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = personX + dx[i];
                int ny = personY + dy[i];

                if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) {
                    continue;
                }
                if (map[nx][ny] == '#' || personMap[nx][ny] != -1) {
                    continue;
                }
                if (fireMap[nx][ny] == -1 || personMap[personX][personY] + 1 < fireMap[nx][ny]) {
                    personQ.offer(new int[]{nx, ny});
                    personMap[nx][ny] = personMap[personX][personY] + 1;
                }
            }
        }
        return -1;
    }

    private static boolean isOnEdge(int x, int y) {
        return (x == 0 || y == 0 || x == N - 1 || y == M - 1);
    }
}