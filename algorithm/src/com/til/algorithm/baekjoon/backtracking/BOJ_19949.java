package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19949 {
    static int count;
    static int[] answers = new int[10];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < answers.length; i++) {
            answers[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(new int[10], 0, 0);
        System.out.println(count);
    }

    private static void backtracking(int[] mySolutions, int solutionCount, int index) {
        // 최적화 !
        if (10 - (index + solutionCount) < 5) {
            return;
        }
        if (index == 10) {
            if (solutionCount >= 5) {
                count++;
            }
        } else {
            int nowAnswer = 0;
            if (index >= 2) {
                if (mySolutions[index - 1] == mySolutions[index - 2]) {
                    nowAnswer = mySolutions[index - 1];
                }
            }
            for (int i = 1; i <= 5; i++) {
                if (i == nowAnswer) continue;

                mySolutions[index] = i;
                if (answers[index] == i) {
                    backtracking(mySolutions, solutionCount + 1, index + 1);
                } else {
                    backtracking(mySolutions, solutionCount, index + 1);
                }
                mySolutions[index] = 0;
            }
        }
    }
}
