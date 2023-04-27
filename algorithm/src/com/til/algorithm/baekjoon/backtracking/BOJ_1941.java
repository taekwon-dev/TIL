package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1941 {

    private static char[][] map = new char[5][5];
    private static boolean[] visited = new boolean[25];
    private static int[] seven = new int[7];
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }
        backtracking(0, 0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int start) {
        if (depth == 7) {
            if (canBeSeven()) {
                answer++;
            }
            return;
        }
        for (int i = start; i < 25; i++) {
            if (!visited[i]) {
                seven[depth] = i;
                visited[i] = true;
                backtracking(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean canBeSeven() {
        int Y = 0;
        for (int i : seven) {
            if (map[i / 5][i % 5] == 'Y') {
                Y++;
            }
            if (Y > 3) {
                return false;
            }
        }

        ArrayList<Integer> member = new ArrayList<>();
        for (int m : seven) {
            member.add(m);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(seven[0]);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now / 5 + dx[i];
                int ny = now % 5 + dy[i];

                if (nx < 0 || ny < 0 || nx > 4 || ny > 4) {
                    continue;
                }
                if (member.contains(nx * 5 + ny)) {
                    member.remove(Integer.valueOf(nx * 5 + ny));
                    queue.offer(nx * 5 + ny);
                }
            }
        }
        if (!member.isEmpty()) {
            return false;
        }
        return true;
    }
}