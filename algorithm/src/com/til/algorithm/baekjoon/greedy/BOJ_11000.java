package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 강의실 배정
 * <p>
 * 그리디 알고리즘 + 우선순위 큐
 * <p>
 * "버리는 시간을 최소로 하면서 강의를 배정해야 최소한의 강의실 개수를 알아낼 수 있다"
 * <p>
 * "어떻게 하면 버리는 시간을 최소화 할 수 있을까?"
 * <p>
 * "정렬" -> 시작 기준
 * <p>
 * https://loosie.tistory.com/480
 * https://steady-coding.tistory.com/253 -> 종료 시간 기준 정렬 반례 제공
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
