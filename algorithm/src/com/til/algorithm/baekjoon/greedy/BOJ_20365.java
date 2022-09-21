package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 블로그 2
 * <p>
 * neighbor 블로그를 운영하는 일우는 매일 아침 풀고 싶은 문제를 미리 정해놓고 글을 올린다.
 * 그리고 매일 밤 각각의 문제에 대하여, 해결한 경우 파란색, 해결하지 못한 경우 빨간색으로 칠한다.
 * <p>
 * 일우는 각 문제를 칠할 때 아래와 같은 과정을 한 번의 작업으로 수행한다.
 * 1. 연속된 임의의 문제들을 선택한다.
 * 2. 선택된 문제들을 전부 원하는 같은 색으로 칠한다.
 * <p>
 * <p>
 * 일우는 매일 500,000문제까지 시도하기 때문에, 이 작업이 꽤나 귀찮아지기 시작했다.
 * 그래서 가장 효율적인 방법으로 위 작업을 수행하기를 원한다.
 * 일우를 도와 각 문제를 주어진 색으로 칠할 때
 * 필요한 최소한의 작업 횟수를 구하는 프로그램을 작성하라.
 * <p>
 * 첫째 줄에 일우가 주어진 모든 문제를 원하는 색으로 칠할 때까지 필요한 작업 횟수의 최솟값을 출력하라.
 * <p>
 * 문제의 수 N (1 ≤ N ≤ 500,000)
 * <p>
 * 1 B
 * 2 B
 * <-->
 * 3 R
 * <-->
 * 4 B
 * <-->
 * 5 R
 * <-->
 * 6 B
 * 7 B
 * <-->
 * 8 R
 * <p>
 * 연속된 문제이므로 위와 같이 5칸으로 나뉜다 (-> 6번을 칠해야 한다)
 * 하지만 1 ~ 7을 한번에 B(= 1번 색)으로 칠한 뒤, 필요한 부분만 R로 칠하면 4번만 칠해도 같은 결과를 얻을 수 있다.
 * <p>
 * // 시작과 끝이 다른 경우
 * // 1 ~ N - 1 까지 칠해야 한다.
 * // 그 다음 첫 색과 다른 수 만큼 고른다. (단 아래와 같이 파티션이 나뉜 경우) ( 1 ~ N 범위에서)
 * BB / R / B / R / BB / R
 * [1] [2] [3] [4] [5] [6]
 * <p>
 * // 시작과 끝이 같은 경우
 * // 1 ~ N 까지 칠해도 된다.
 * // 그 다음 첫 색과 다른 수 만큼 고른다. (단 아래와 같이 파티션이 나뉜 경우) ( 1 ~ N - 1 범위에서)
 * BB / R / B / R / BBB
 * [1] [2] [3] [4] [5]
 * <p>
 * <p>
 * BB / R / B / R / BB / R
 * <p>
 * 1   2    3  4   5    6  -> 배열 -> 4번 (처음 칠할 때 마지막이 포함되지 않아서)
 * <p>
 * BB / R / B / R / BBB
 * 1   2    3   4   5  -> 배열 -> 3번
 */
public class BOJ_20365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] colors = br.readLine().toCharArray();

        ArrayList<Character> list = new ArrayList<>();
        list.add(colors[0]);
        for (int i = 0; i < n - 1; i++) {
            if (colors[i] != colors[i + 1]) {
                list.add(colors[i + 1]);
            }
        }

        int answer = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(0) != list.get(i)) {
                answer++;
            }
        }

        if (list.get(0) == list.get(list.size() - 1)) {
            answer += 1;
        } else {
            answer += 2;
        }
        System.out.println(answer);
    }
}
