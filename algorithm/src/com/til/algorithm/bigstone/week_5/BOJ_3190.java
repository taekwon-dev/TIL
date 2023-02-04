package com.til.algorithm.bigstone.week_5;

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

    private static int N;
    private static int K;
    private static int d;
    private static int[][] map;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static ArrayList<Node> snakes = new ArrayList<>();
    private static HashMap<Integer, Character> directions = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N][N];

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
            char direction = st.nextToken().charAt(0);
            directions.put(sec, direction);
        }

        bw.write(solution(0, 0) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int solution(int x, int y) {
        int time = 0;
        snakes.add(new Node(x, y));

        while (true) {
            time++;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) {
                break;
            }
            boolean flag = false;
            for (int i = 0; i < snakes.size(); i++) {
                int selfX = snakes.get(i).x;
                int selfY = snakes.get(i).y;

                if (nx == selfX && ny == selfY) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
                snakes.add(new Node(nx, ny));
            } else {
                snakes.add(new Node(nx, ny));
                snakes.remove(0);
            }
            if (directions.containsKey(time)) {
                if (directions.get(time) == 'D') {
                    d++;
                    if (d == 4) {
                        d = 0;
                    }
                } else if (directions.get(time) == 'L') {
                    d--;
                    if (d == -1) {
                        d = 3;
                    }
                }
            }
            x = nx;
            y = ny;
        }
        return time;
    }
}