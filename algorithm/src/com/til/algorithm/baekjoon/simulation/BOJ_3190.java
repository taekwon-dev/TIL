package com.til.algorithm.baekjoon.simulation;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_3190 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    private static int N;
    private static int D;
    private static int[][] map;
    private static ArrayList<Node> snake = new ArrayList<>();
    private static HashMap<Integer, Character> direction = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            map[x][y] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);

            direction.put(sec, d);
        }

        int answer = move(0, 0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int move(int x, int y) {
        int cost = 0;
        snake.add(new Node(x, y));

        while (true) {
            cost++;

            int nx = x + dx[D];
            int ny = y + dy[D];

            if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) {
                break;
            }
            boolean flag = false;
            for (int i = 0; i < snake.size(); i++) {
                int sx = snake.get(i).x;
                int sy = snake.get(i).y;

                if (sx == nx && sy == ny) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }

            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
                snake.add(new Node(nx, ny));
            } else {
                snake.add(new Node(nx, ny));
                snake.remove(0);
            }

            if (direction.containsKey(cost)) {
                if (direction.get(cost) == 'D') {
                    D++;
                    if (D == 4) {
                        D = 0;
                    }
                } else if (direction.get(cost) == 'L') {
                    D--;
                    if (D == -1) {
                        D = 3;
                    }
                }
            }
            x = nx;
            y = ny;
        }
        return cost;
    }
}