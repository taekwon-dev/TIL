package com.til.algorithm.dev_matching_2022.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/18.
 * Title : 연산자 끼워넣기 (https://www.acmicpc.net/problem/14888)
 * Hint  : https://st-lab.tistory.com/121
 */
public class BOJ_14888 {

    /**
     *  N 개의 수열 & N - 1 개의 연산자 ( +, -, *, / )
     *
     *  주어진 상황 (괄호 = 사용할 수 있는 연산자 수)
     *  [ 1, 2, 3, 4, 5, 6 ]
     *  + (2)
     *  - (1)
     *  * (1)
     *  / (1)
     *
     *  5 자리 (연산자가 들어갈 수 있는 자리)
     *  따라서, 순열을 사용하여 5! = 120 이지만, +1, +2 는 서로 자리를 바꿔도 같은 것으로 보기 때문에 + 수 만큼 나누면 60 가지를 표현할 수 있다.
     *
     *  수능에서 남자, 남자, 여자, 여자, 여자 = 줄 세우는 문제와 같음
     *
     *  최댓값, 최솟값을 구하기 위해 연산자가 들어갈 수 있는 자리수에 넣어보면서 체크를 해야한다. 단, 빼기, 나누기가 있으므로 값이 일방향으로 크거나 작아지기만 하지는 않으므로
     *  모든 경우를 카운트 해야 한다.
     */
    static int n;
    static int[] nums;
    static int[] operators = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(1, nums[0]);
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
            if (operators[i] > 0) {
                operators[i] -= 1;
                switch (i) {
                    case 0 : backtracking(depth + 1, num + nums[depth]); break;
                    case 1 : backtracking(depth + 1, num - nums[depth]); break;
                    case 2 : backtracking(depth + 1, num * nums[depth]); break;
                    case 3 : backtracking(depth + 1, num / nums[depth]); break;
                }
                operators[i] += 1;
            }
        }
    }


}
