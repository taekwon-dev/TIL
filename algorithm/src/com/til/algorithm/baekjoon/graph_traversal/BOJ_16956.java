package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  늑대와 양
 *
 *  각각의 칸에는 비어있거나, 양 또는 늑대
 *  양은 이동하지 않고 위치를 지키고 있고, 늑대는 인접한 칸을 자유롭게 이동할 수 있다
 *  늑대는 울타리가 있는 칸으로는 이동할 수 없다. 울타리를 설치 -> 양이 있는 곳으로 올 수 없도록
 *
 *  . -> 빈 칸
 *  s -> 양
 *  w -> 늑대
 *
 *  이미 양과 늑대가 인접한 경우 사이에 울타리를 설치할 수 없으므로 -> 0
 *
 */
public class BOJ_16956 {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int r, c;
    static char[][] map;
    static boolean flag = true;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = row.charAt(j);
            }
        }
        bfs();
        if (flag) {
            System.out.println(1);
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println(0);
        }

    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'W') {
                    queue.add(new Node(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    if (map[nx][ny] == '.') {
                        map[nx][ny] = 'D';
                    }

                    if (map[nx][ny] == 'S') {
                        flag = false;
                        return;
                    }
                }
            }
        }

    }
}