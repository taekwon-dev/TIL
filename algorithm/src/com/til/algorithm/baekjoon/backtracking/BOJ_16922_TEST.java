package com.til.algorithm.baekjoon.backtracking;

/**
 *  출력 결과 예상 해보기
 */
public class BOJ_16922_TEST {
    static int[] arr = {1, 2, 3};
    static int[] tmp = new int[3];

    public static void main(String[] args) {
        backtracking(0, 0);
    }

    private static void backtracking(int depth, int index) {
        if (depth == 3) {
            for (int i = 0; i < 3; i++) {
                System.out.print(tmp[i]);
            }
            System.out.println();
            return;
        }
        for (int i = index; i < 3; i++) {
            tmp[depth] = arr[i];
            backtracking(depth + 1, i);
        }
    }
}
