package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  영재의 시험
 *
 *  문제가 5지 선다의 객관식 10문제였다
 *
 *  3개의 연속된 문제의 답은 같지 않게 한다는 자신의 비법
 *
 *  이때 영재의 점수가 5점 이상일 경우의 수
 *
 *  1문제당 1점씩
 *
 *  1, 1, (2~5) ...
 *
 *  같은 수를 여번 사용할 수 있는데,
 *  같은 수가 두 번까지만 연속으로 뽑힐 수 있다
 *
 *  {2, 2, 2, 2, 2} -> 1, 2, 3, 4, 5 가 연속적으로 나올 수 있는 수를 관리
 *
 *  1, 1, ?, ...
 *
 *  ? 를 고르는 시점
 *
 *  {0, 2, 2, 2, 2} 상태이므로, 2 ~ 5 중 하나를 고를 수 있도록 한다. (2 ~ 5 중 하나 고르면, 다시 초기화)
 *
 *
 */
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
