package com.til.algorithm.baekjoon.backtracking;

/**
 *  3 X 3 (2차원 배열)
 *
 *  각 줄마다 하나씩 놓을 수 있는 방법
 *
 *  3^3 = 27
 *
 *  N-Queen 문제를 풀기 위한 기본 아이디어
 *
 */
public class BOJ_9663_0 {
    static boolean[][] visited = new boolean[3][3];
    static int count;
    public static void main(String[] args) {
        backtracking(0);
        System.out.println(count);
    }

    private static void backtracking(int depth) {
        if (depth == 3) {
            count++;
            print2DArr();
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (!visited[depth][i]) {
                visited[depth][i] = true;
                backtracking(depth + 1);
                visited[depth][i] = false;
            }
        }
    }

    private static void print2DArr() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Count : " + count);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(visited[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
