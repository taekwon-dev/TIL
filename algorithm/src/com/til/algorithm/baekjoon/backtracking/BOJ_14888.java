package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  연산자 끼워넣기
 *
 *  N 개의 수
 *  N - 1 개의 연산자 수
 *  (+, -, *, /)
 *
 *  주어진 수의 순서를 바꾸지 않은 상태에서
 *  연산자를 조합하여 수식을 만든다.
 *
 *  식의 계산은 연산자 우선순위를 고려하지 않고, 앞에서부터 순차적으로 진행한다.
 *  (음수를 양수로 나눌 때는 C++14의 기준을 따른다. 즉, 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다. 이에 따라서, 위의 식 4개의 결과를 계산해보면 아래와 같다.)
 *
 *  최댓값 / 최솟값 구하기 (-10억 ~ 10익)
 *
 *  1 2 3 4 5 6 -> 6개의 수
 *  들어 갈 수 있는 연산자 자리 -> 5
 *
 *  연산자 종류 -> +(2), -(1), *(1), /(1)
 *
 *  5! / 2! = 120 / 2 = 60개의 수식
 *
 *  중복순열
 *
 *  + + - * /
 *  + - + * /
 *  .
 *  .
 *  연산자를 모두 채우고, 최소-최대를 구하는 문제
 *  첫째 줄에 수의 개수 N(2 ≤ N ≤ 11)
 *
 *  연산자를 사용 했다가 다시 돌려줘야 한다.
 */
public class BOJ_14888 {
    static int n;
    static int[] arr;
    static int[] ops;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        ops = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        // 시작을 0으로 두면, 0을 나누게 돼서 나누기에 영향을 준다.
        backtracking(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void backtracking(int depth, int sum) {
        if (depth == n) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        // 연산자 수 만큼 활용할 수 있다.
        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) {
                ops[i] -= 1;
                if (i == 0) {
                    // +
                    backtracking(depth + 1, sum + arr[depth]);
                } else if (i == 1) {
                    // -
                    backtracking(depth + 1, sum - arr[depth]);
                } else if (i == 2) {
                    // *
                    backtracking(depth + 1, sum * arr[depth]);
                } else if (i == 3) {
                    // /
                    backtracking(depth + 1, sum / arr[depth]);
                }
                ops[i] += 1;
            }
        }
    }
}
