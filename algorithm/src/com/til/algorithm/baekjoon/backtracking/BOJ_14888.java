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
 *  N - 1 개의 연산자를 배치한다.
 *  연산자 수가 정해져 있다.
 *
 *  5 개의 수
 *  4 연산자
 *
 *  + : 2
 *  - : 2
 *
 *  4! = 24
 *  + 간, - 간 구분이 안되므로 2! 2! 으로 나눈다. (중복 제거)
 *
 *  24 / 4 = 6
 *
 *  1 + 2 + 3 - 4 - 5
 *  1 + 2 - 3 + 4 - 5
 *  1 + 2 - 3 - 4 + 5
 *  1 - 2 - 3 + 4 + 5
 *  1 - 2 + 3 - 4 + 5
 *  1 - 2 + 3 + 4 - 5
 */
public class BOJ_14888 {
    static int n;
    static int[] arr;
    static int[] ops = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < ops.length; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void backtracking(int depth, int num) {
        if (depth == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) {
                ops[i] -= 1;
                switch (i) {
                    case 0: backtracking(depth + 1, num + arr[depth]); break;
                    case 1: backtracking(depth + 1, num - arr[depth]); break;
                    case 2: backtracking(depth + 1, num * arr[depth]); break;
                    case 3: backtracking(depth + 1, num / arr[depth]); break;
                }
                ops[i] += 1;
            }
        }

    }
}
