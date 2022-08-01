package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *  강의실 배정
 *
 *  수강신청의 마스터 김종혜 선생님에게 새로운 과제가 주어졌다.
 *  김종혜 선생님한테는 Si에 시작해서 Ti에 끝나는 N개의 수업이 주어지는데, 최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다.
 *  참고로, 수업이 끝난 직후에 다음 수업을 시작할 수 있다. (즉, Ti ≤ Sj 일 경우 i 수업과 j 수업은 같이 들을 수 있다.)
 *  수강신청 대충한 게 찔리면, 선생님을 도와드리자!
 *
 *  첫 번째 줄에 N이 주어진다. (1 ≤ N ≤ 200,000)
 *
 *  200,000
 *
 *  N 개의 수업
 *
 *  최소의 강의실 -> 모든 수업을 커버 (수업 끝난 시간과 다음 수업 시작 시간은 겹쳐도 된다)
 *
 *  예)
 *  N = 3
 *
 *  1    3
 *    2     4
 *       3     5
 *
 *
 *  1개
 *  1 - 3
 *      3 - 5
 *
 *  2개
 *  2 - 4
 *
 *  강의실을 최대한 적게 사용하려면 -> 한 강의실에 최대한 많은 강의를 배정해야한다.
 *  한 강의실을 배정하는 것을 끝내면, 선택되지 않은 강의에 대해서 위 기준으로 배정 반복 (다 배정할 때 까지)
 */
public class BOJ_11000_TIMEOUT {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        boolean[][] assigned = new boolean[n][2];
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

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int end = arr[0][1];
        int count = 0;
        int answer = 0;

        while (true) {
            if (count == n) {
                break;
            }
            for (int i = 0; i < n; i++) {
                // 이 전 수업의 끝나는 시간 <= (다음) 수업의 시작 시간 -> 두 수업이 한 강의실에 배정 가능
                if (end <= arr[i][0]) {
                    // 아직 배정된 수업이 아닌 경우
                    if (!assigned[i][0]) {
                        // 끝나는 시간 업데이트
                        end = arr[i][1];
                        // 배정한 수업 체크 (시작시간으로 체크)
                        assigned[i][0] = true;
                        count++;
                    }
                }
            }
            answer++;
        }
        System.out.println(answer);
    }
}
