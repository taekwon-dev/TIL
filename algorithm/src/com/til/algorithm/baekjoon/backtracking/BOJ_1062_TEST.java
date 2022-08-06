package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  가르침
 *
 *  선택한 알파벳이 어떻게 구성되는 지 출력
 *
 */
public class BOJ_1062_TEST {
    static int k;
    static boolean[] visited;
    static int[] test;

    public static void main(String[] args) throws IOException {
        k = 3;
        test = new int[k];
        visited = new boolean[26];

        backtracking(0, 0);
        //backtracking2(0);
    }

    private static void backtracking(int depth, int index) {
        if (depth == k) {
            for (int i = 0; i < k; i++) {
                System.out.print(test[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = index; i < 5; i++) {
            if (!visited[i]) {
                visited[i] = true;
                test[depth] = i;
                backtracking(depth + 1, i);
                visited[i] = false;
            }
        }
    }

    private static void backtracking2(int depth) {
        if (depth == k) {
            for (int i = 0; i < k; i++) {
                System.out.print(test[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < 5; i++) {
            if (!visited[i]) {
                visited[i] = true;
                test[depth] = i;
                backtracking2(depth + 1);
                visited[i] = false;
            }
        }
    }
}

/*
B1
0 1 2
0 1 3
0 1 4
0 2 3
0 2 4
0 3 4
1 2 3
1 2 4
1 3 4
2 3 4

B2
0 1 2
0 1 3
0 1 4
0 2 1
0 2 3
0 2 4
0 3 1
0 3 2
0 3 4
0 4 1
0 4 2
0 4 3
1 0 2
1 0 3
1 0 4
1 2 0
1 2 3
1 2 4
1 3 0
1 3 2
1 3 4
1 4 0
1 4 2
1 4 3
2 0 1
2 0 3
2 0 4
2 1 0
2 1 3
2 1 4
2 3 0
2 3 1
2 3 4
2 4 0
2 4 1
2 4 3
3 0 1
3 0 2
3 0 4
3 1 0
3 1 2
3 1 4
3 2 0
3 2 1
3 2 4
3 4 0
3 4 1
3 4 2
4 0 1
4 0 2
4 0 3
4 1 0
4 1 2
4 1 3
4 2 0
4 2 1
4 2 3
4 3 0
4 3 1
4 3 2
 */