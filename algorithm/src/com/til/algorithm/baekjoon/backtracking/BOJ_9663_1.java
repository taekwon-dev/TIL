package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  N-Queen
 *
 *  N * N 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제
 *  N이 주어졌을 때, 퀸을 놓는 방법의 수
 *  첫째 줄에 N이 주어진다. (1 ≤ N < 15)
 *
 *  나무위키
 *  Queen. 체스의 기물 중 하나. 가마에 탄 왕비의 형태라고 한다.
 *  좌우, 상하, 대각선. 모든 방향으로 이동 가능하다.
 *  즉, 룩과 비숍의 능력을 모두 가지고 있는 말이다. 전투력은 모든 말 중 최강.
 *
 *  N = 4
 *  네 곳에 퀸을 착수하고 -> 각각의 퀸을 기준으로 (총 4번) 다른 퀸에 도달하는 지 (= 서로 공격하는 상황이 되는 지) 체크
 *  만약, 다른 퀸에 도달할 수 있다면 서로 공격이 가능한 위치이므로 넘긴다.
 *
 *  퀸의 위치는 1 세팅
 *  빈 칸 위치는 0 세팅
 *
 *  퀸이 이동할 수 있는 곳을 0으로 지정하고 그래프 탐색 (DFS or BFS) 진행
 *
 *  ------
 *
 *  N = 4
 *  네 곳의 퀸을 착수할 수 있는 지를 검사
 *  즉 퀸을 위치에 놓을 때 마다 공격을 주고 받을 수 있는 위치가 아닌 지 체크하면서 진행
 *  최종적으로 네 곳의 위치에 퀸을 위치할 수 있다면 경우의 수에 추가
 *
 *
 *
 *
 */
public class BOJ_9663 {
    static int n, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        backtracking(0);
        System.out.println(answer);
    }

    private static void backtracking(int depth) {
        if (depth == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            if (check(depth)) {
                backtracking(depth + 1);
            }
        }
    }

    private static boolean check(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) {
                return false;
            } else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }

}
