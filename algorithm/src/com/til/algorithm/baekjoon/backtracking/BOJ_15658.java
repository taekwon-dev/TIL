package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  연산자 끼워넣기 (2)
 *
 *  N개의 수
 *
 *  연산자 = {+, -, *, /}
 *  N-1개의 연산자 수
 *  연산자의 개수는 N-1보다 많을 수도 있다.
 *
 *  예시)
 *  1, 2, 3, 4, 5, 6 -> 연산자가 들어갈 자리는 5곳
 *  덧셈(+) 3개, 뺄셈(-) 2개, 곱셈(×) 1개, 나눗셈(÷) 1개를 활용할 수 있다면,
 *
 *  7 P 5 = 7! / 2! * (3! * 2!)
 *  7 5 2 3 = 210
 *
 *  연산은 순차적으로 적용 (우선순위 X)
 *  N개의 수와 연산자가 주어졌을 때, 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램을 작성하시오.
 *
 *  2 <= N <= 11
 *  1 <= A(i)<= 100
 *
 *  11개의 수 10개의 연산자리에 모두 * 가 들어오면 = 최댓값
 *  100^10 = 100,000,000,000,000,000,000
 *
 *  단 출력 조건에서
 *  연산자를 어떻게 끼워넣어도 항상 -10억보다 크거나 같고, 10억보다 작거나 같은 결과가 나오는 입력만 주어진다.
 *
 */
public class BOJ_15658 {
    static int n;
    static int[] arr;
    static int[] ops = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void backtracking(int depth, int sum) {
        // N 개의 수
        // N - 1 개의 연산자 수
        // 첫 시작이 1번째 인덱스 부터 시작이므로 n개 될 때 연산자가 n-1 개 채워진다
        if (depth == n) {
            // 최소, 최대 값 계산
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }
        int next = arr[depth];
        for (int i = 0; i < 4; i++) {
            // + -> - -> * -> / 순서로 각 개수만큼 처리
            if (ops[i] <= 0) continue;
            int prev_sum = sum;
            if (i == 0) {
                prev_sum += next;
            } else if (i == 1) {
                prev_sum -= next;
            } else if (i == 2) {
                prev_sum *= next;
            } else {
                prev_sum /= next;
            }

            ops[i]--;
            backtracking(depth + 1, prev_sum);
            ops[i]++;
        }
    }
}
