package com.til.algorithm.algorithm.graph_traversal;


import java.util.LinkedList;
import java.util.Queue;

/**
 *  Flood Fill (or Seed Fill) 알고리즘은 다차원 배열의 어떤 칸과 연결된 영역을 찾는 알고리즘이다.
 *  이 알고리즘은 그림판과 같은 프로그램에서 연결된 비슷한 색을 가지는 영역에 채우기 도구에 사용되며,
 *  바둑이나 지뢰 찾기 게임에서 어떤 비어 있는 칸을 표시할 지를 결정할 때에도 사용된다.
 */

public class FloodFill {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[][] map = new int[4][4];
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int answer;

    public static void main(String[] args) {
        map[2][1] = 1;

        /**
         *  0 0 0 0
         *  0 0 0 0
         *  0 1 0 0
         *  0 0 0 0
         *    (전)
         */
        print2DArray();
        floodFill();

        /**
         *  4 3 4 5
         *  3 2 3 4
         *  2 1 2 3
         *  3 2 3 4
         *    (후)
         */
        print2DArray();

        // 모든 배열을 방문하는데 소요된 시간 (answer = 5)
        System.out.println("answer = " + answer);
    }

    private static void floodFill() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(2, 1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) {
                    continue;
                }
                if (map[nx][ny] != 0) {
                    continue;
                }
                map[nx][ny] = map[node.x][node.y] + 1;
                queue.offer(new Node(nx, ny));

                if (map[nx][ny] > answer) {
                    answer = map[nx][ny];
                }
            }
        }

    }

    private static void print2DArray() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
