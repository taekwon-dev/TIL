package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 토마토
 * <p>
 * 익은 토마토 / 익지 않은 토마토
 * 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다
 * 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
 * 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
 * <p>
 * 하루 기준으로, 인접한 곳의 토마토가 익은 경우 익지 않은 토마토는 익는다.
 * 2 ≤ M,N ≤ 1,000
 * <p>
 * 정수 1은 익은 토마토,
 * 정수 0은 익지 않은 토마토,
 * 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
 * <p>
 * 여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다. = map 에서 익지 않은 토마토가 없어야 한다.
 * 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,
 * 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
 * <p>
 * 최초 맵을 순회하면서 익지 않은 토마토에 영향을 주는 대상을 모두 queue 에 넣는다.
 * 익은 토마토 노드를 기준으로 BFS 순회 하면서 익지 않은 토마토를 익게 만들고 다시 queue 에 넣는다.
 * <p>
 * BFS 연산 후, 저장되어 있는 토마토 중 익지 않은 토마토가 있는 경우 -1 출력
 * 모든 토마토가 익은 경우 - 소요된 최소 날짜 출력
 * 이미 다 익은 상태였다면 - 0 출력
 */
public class BOJ_7576 {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int m, n;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 익은 토마토 큐 대기열에 추가
                if (map[i][j] == 1) {
                    queue.add(new Node(i, j));
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] == 0) {
                        queue.add(new Node(nx, ny));
                        map[nx][ny] = map[node.x][node.y] + 1;
                    }
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    return -1;
                }
                answer = Math.max(answer, map[i][j]);
            }
        }

        if (answer == 1) {
            // 최초 저장 시 모든 토마토가 익은 상태
            return 0;
        } else {
            // 익은 토마토가 1로 설정되어 있어서 날짜 계산시 -1 처리 필요
            return answer - 1;
        }
    }
}
