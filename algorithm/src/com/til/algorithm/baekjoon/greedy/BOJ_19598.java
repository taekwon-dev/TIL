package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 최소 회의실 개수
 *
 * N = 회의 개수
 *
 * N개의 회의를 모두 진행할 수 있는 최소 회의실 개수를 구하라는 미션을 받았다
 * 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다
 *
 * 결과적으로 N개의 회의가 모두 진행 될 수 있도록 회의실을 확보해야 하는데,
 * 최소 회의실 개수를 가질 수 있도록 한다.
 * (= 하나의 회의실에 최대로 넣을 수 있는 만큼 회의를 배정하자) -> Greedy
 *
 * 시작 시간이 빠를수록 (= 회의가 빨리시작할수록)
 * 끝나는 시간이 빠를수록 (= 회의가 짧을수록)
 *
 * N = 3
 *
 * 0  40
 * 15 30
 * 5  10
 *
 * 1차 정렬 = 시작 시간이 빠를수록
 * 0  40
 * 5  10
 * 15 30
 *
 * 2차 정렬 = 끝나는 시간이 빠를수록
 * 5  10
 * 15 30
 * 0  40
 *
 * 5  10 -> A
 * 15 30 -> A
 * 0  40 -> B
 *
 * 따라서 위 세 개의 회의를 모두 배정하기 위해서는 최소 2개의 회의실을 확보해야 한다.
 *
 * 1 - 4 -> A
 * 3 - 5
 * 0 - 6
 * 5 - 7 -> A
 * 3 - 8
 * 5 - 9
 * 6 - 10
 * 8 - 11 -> A
 * 8 - 12
 * 2 - 13
 * 12 - 14 -> A
 *
 * 3 - 5 -> B
 * 0 - 6
 * 3 - 8
 * 5 - 9 -> B
 * 6 - 10
 * 8 - 12
 * 2 - 13
 *
 * 0 - 6 -> C
 * 3 - 8
 * 6 - 10 -> C
 * 8 - 12
 * 2 - 13
 *
 * 3 - 8 -> D
 * 8 - 12 -> D
 * 2 - 13 -> E
 *
 * 첫째 줄에 최소 회의실 개수를 출력한다.
 *
 */
public class BOJ_19598 {
    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.start == o.start) {
                return this.end - o.end;
            } else {
                return this.start - o.start;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(s, e));
        }
        Collections.sort(meetings);

        Queue<Integer> pq = new PriorityQueue<>();
        int end = 0;

        for (Meeting meeting : meetings) {
            end = meeting.end;

            if (!pq.isEmpty() && pq.peek() <= meeting.start) {
                pq.poll();
            }
            pq.add(end);
        }
        System.out.println(pq.size());
    }
}
