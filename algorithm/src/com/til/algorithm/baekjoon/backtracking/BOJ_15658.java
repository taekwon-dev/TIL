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
 *  연산자의 개수는 N-1보다 많을 수도 있다. (-> 연산자 끼워넣기 14888과 다른 부분이지만, 풀이는 같음)
 *
 *  예시)
 *  1, 2, 3, 4, 5, 6 -> 연산자가 들어갈 자리는 5곳 (선택한 연산자의 순서가 값에 영향을 준다는 점에서 순서가 중요하다고 할 수 있다 -> 순열)
 *  덧셈(+) 3개, 뺄셈(-) 2개, 곱셈(×) 1개, 나눗셈(÷) 1개를 활용할 수 있다면,
 *
 *
 *  7P5 = 7! / 2! = 7 6 5 4 3 = 2520
 *  위 경우의 수에서 + + + , - - 와 같이 같은 연산이 적용된 경우 같은 수식을 만들어 내므로 이런 경우를 제외하면 250가지만 나온다.
 *  (일단 + + + - - 가 모두 선택된 경우)
 *
 *
 *  3! = 6
 *  2! = 2
 *
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
    static int count;

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
        System.out.println(count);

    }

    private static void backtracking(int depth, int sum) {
        if (depth == n) {
            count++;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) {
                ops[i]--;
                if (i == 0) {
                    backtracking(depth + 1, sum + arr[depth]);
                } else if (i == 1) {
                    backtracking(depth + 1, sum - arr[depth]);
                } else if (i == 2) {
                    backtracking(depth + 1, sum * arr[depth]);
                } else if (i == 3) {
                    backtracking(depth + 1, sum / arr[depth]);
                }
                ops[i]++;
            }

        }
    }

}
