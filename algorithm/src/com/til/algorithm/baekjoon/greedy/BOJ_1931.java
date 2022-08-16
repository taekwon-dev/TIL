package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  회의실 배정
 *
 *  현재 진행중인 회의 시간과 겹치지 않는 남아 있는 회의 시간 중에서 종료 시간이 가장 빠른 회의 시간을 고른다.
 *
 *  https://loosie.tistory.com/475
 *
 */
public class BOJ_1931 {
    static class Meeting implements Comparable<Meeting> {

        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end > o.end) return 1;
            else if (this.end < o.end) return -1;
            else return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Meeting> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Meeting(s, e));
        }
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).start +  " ~ " +  list.get(i).end);
        }

        int answer = 0;
        int end = 0;
        for (Meeting m : list) {
            if (m.start >= end) {
                end = m.end;
                answer++;
            }
        }
        System.out.println(answer);
    }


}
