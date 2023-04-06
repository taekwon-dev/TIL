package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427 {

    private static int Y;
    private static int X;
    private static char[][] map;
    private static int[][] fireMap;
    private static int[][] personMap;
    private static Queue<int[]> fireQ;
    private static Queue<int[]> personQ;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            Y = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map = new char[X][Y];
            fireMap = new int[X][Y];
            personMap = new int[X][Y];
            fireQ = new LinkedList<>();
            personQ = new LinkedList<>();

            for (int i = 0; i < X; i++) {
                Arrays.fill(fireMap[i], -1);
                Arrays.fill(personMap[i], -1);
            }

            for (int i = 0; i < X; i++) {
                String row = br.readLine();
                for (int j = 0; j < Y; j++) {
                    map[i][j] = row.charAt(j);
                    if (map[i][j] == '*') {
                        fireMap[i][j] = 0;
                        fireQ.offer(new int[]{i, j});
                        continue;
                    }
                    if (map[i][j] == '@') {
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
        }
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
        return x >= 0 && y >= 0 && x < X && y < Y;
    }

    private static boolean isOnEdge(int x, int y) {
        return x == 0 || y == 0 || x == X - 1 || y == Y - 1;
    }
}