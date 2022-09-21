package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 토마토 2
 * <p>
 * 하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향
 * <p>
 * 2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100
 * <p>
 * 정수 1은 익은 토마토,
 * 정수 0 은 익지 않은 토마토,
 * 정수 -1은 토마토가 들어있지 않은 칸
 * <p>
 * 여러분은 토마토가 모두 익을 때까지 최소 며칠이 걸리는지를 계산해서 출력해야 한다.
 * 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,
 * 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
 * <p>
 * 익어 있는 토마토 => 영향력이 있다. (주변 익지 않은 토마토를 익게 만든다)
 */
public class BOJ_7569 {


    static class Node {
        int x;
        int y;
        int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int m, n, h;
    static int[][][] map;

    // -> { 1, 0, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 }
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1][h + 1];

        for (int z = 1; z <= h; z++) {
            for (int x = 1; x <= n; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 1; y <= m; y++) {
                    map[x][y][z] = Integer.parseInt(st.nextToken());

                    if (map[x][y][z] == 1) {
                        queue.add(new Node(x, y, z));
                    }
                }
            }
        }

        bfs();
    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int nz = node.z + dz[i];

                if (nx >= 1 && ny >= 1 && nz >= 1 && nx <= n && ny <= m && nz <= h) {
                    if (map[nx][ny][nz] == 0) {
                        queue.add(new Node(nx, ny, nz));
                        map[nx][ny][nz] = map[node.x][node.y][node.z] + 1;
                    }
                }
            }
        }

        // 모든 처리 완료
        // 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,
        // 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
        int max = 0;
        for (int z = 1; z <= h; z++) {
            for (int x = 1; x <= n; x++) {
                for (int y = 1; y <= m; y++) {
                    if (map[x][y][z] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, map[x][y][z]);
                }
            }
        }

        if (max == 1) {
            System.out.println(0);
        } else {
            System.out.println(max - 1);
        }
    }
}
