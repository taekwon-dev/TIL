package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  강의실 배정
 *
 *  그리디 알고리즘 + 우선순위 큐
 *  https://steady-coding.tistory.com/253
 *  https://loosie.tistory.com/480
 *
 *
 @Override
 public int compareTo(Class o) {
 if (this.start == o.start) {
 // 시작 시간이 같으면, 끝나는 시간 기준으로 오름차순
 return this.end - o.end;
 } else {
 return this.start - o.start;
 }
 }
 0 ~ 6
 1 ~ 4
 2 ~ 13
 3 ~ 5
 3 ~ 8
 5 ~ 7
 5 ~ 9
 6 ~ 10
 8 ~ 11
 8 ~ 12
 12 ~ 14


 @Override
 public int compareTo(Class o) {
 if (this.end > o.end) return 1;
 else if (this.end < o.end) return -1;
 else return this.start - o.start;
 }
 1 ~ 4
 3 ~ 5
 0 ~ 6
 5 ~ 7
 3 ~ 8
 5 ~ 9
 6 ~ 10
 8 ~ 11
 8 ~ 12
 2 ~ 13
 12 ~ 14

 */
public class BOJ_11000 {
    static class Class implements Comparable<Class> {

        int start;
        int end;

        public Class(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Class o) {
            if (this.start == o.start) {
                // 시작 시간이 같으면, 끝나는 시간 기준으로 오름차순
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
        List<Class> classes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            classes.add(new Class(s, e));
        }
        Collections.sort(classes);

        Queue<Integer> pq = new PriorityQueue<>();
        int end = 0;
        for (Class c : classes) {
            end = c.end;

            if (!pq.isEmpty() && pq.peek() <= c.start) {
                pq.poll();
            }
            pq.add(end);
        }
        System.out.println(pq.size());
    }

}
