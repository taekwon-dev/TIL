package com.til.algorithm.baekjoon.graph_traversal;

/**
 *  배열 복사 테스트
 *
 *  얕은 복사 - 주솟값 복사, 복사한 뒤 값을 변경하면 원래 참조한 배열 값도 변경
*
 *  깊은 복사 - 새로운 배열 생성
 */
public class BOJ_14502_TEST2 {
    public static void main(String[] args) {
        int[][] map = new int[3][3];
        int[][] copyMap = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = 3;
            }
        }
        copyMap = map;

        print2DArray(copyMap);
    }

    private static void print2DArray(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
