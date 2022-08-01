package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 *  회의실 배정
 *
 *  한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의
 *
 *  각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고,
 *  각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 "최대" 개수를 찾아보자
 *  (단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다)
 *
 *  1 4
 *  3 5
 *  0 6
 *  5 7
 *  3 8
 *  5 9
 *  6 10
 *  8 11
 *  8 12
 *  2 13
 *  12 14
 *  위 두 회의는 시간이 겹치므로 해당 회의실을 모두 사용할 수 없다 (= 둘 중 하나는 포기)
 *
 *  A B
 *  A가 먼저 시작하는 경우 (시작 시간이 앞선 경우)
 *  A의 끝나는 시간 <= B의 시작시간이어야 A, B 모두 회의실 이용이 가능하다.
 *
 *  -> 시작 시간이 빠르고, 끝나는 시간이 빠를 수록 (-> 앞에 있는 애들이 짧을 수록 뒤에 선택할 여지가 많다)
 *
 *  3--5
 *     5--7
 *         8---11
 *              12--14
 *
 * 1 4
 * 3 5
 * 0 6
 * 5 7
 * 3 8
 * 5 9
 * 6 10
 * 8 11
 * 8 12
 * 2 13
 * 12 14
 * 0 - 6
 *
 * [시작 시간 기준 정렬] - 오름차순
 * 1 - 4
 * 2 - 13
 * 3 - 5
 * 3 - 8
 * 5 - 7
 * 5 - 9
 * 6 - 10
 * 8 - 11
 * 8 - 12
 * 12 - 14
 *
 * [끝나는 시간 기준 정렬] - 오름차순
 * 1 - 4
 * 3 - 5
 * 0 - 6
 * 5 - 7
 * 3 - 8
 * 5 - 9
 * 6 - 10
 * 8 - 11
 * 8 - 12
 * 2 - 13
 * 12 - 14
 *
 * 빨리 시작하고, 빨리 끝나는 기준으로 정렬
 * = 최대한 많은 강의를 배정
 *
 */
public class BOJ_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + " - " + arr[i][1]);
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + " - " + arr[i][1]);
        }

        int answer = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i][0] >= end) {
                end = arr[i][1];
                answer++;
            }
        }
        System.out.println(answer);
    }
}