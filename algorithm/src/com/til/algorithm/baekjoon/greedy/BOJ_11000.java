package com.til.algorithm.baekjoon.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11000 {
    static class Course implements Comparable<Course> {

        int s;
        int e;

        public Course(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Course o) {
            if (this.s == o.s) {
                return this.e - o.e;
            } else {
                return this.s - o.s;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            courses.add(new Course(start, end));
        }
        Collections.sort(courses);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int endTime = 0;
        for (Course c : courses) {
            endTime = c.e;
            if (!pq.isEmpty() && pq.peek() <= c.s) {
                pq.poll();
            }
            pq.add(endTime);
        }
        System.out.println(pq.size());
    }

}
