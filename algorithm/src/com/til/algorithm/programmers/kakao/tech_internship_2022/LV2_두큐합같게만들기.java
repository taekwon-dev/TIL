package com.til.algorithm.programmers.kakao.tech_internship_2022;

import java.util.ArrayDeque;
import java.util.Queue;

public class LV2_두큐합같게만들기 {

    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        long s1 = 0;
        long s2 = 0;
        long sum = 0;
        for (int i = 0; i < queue1.length; i++) {
            s1 += queue1[i];
            q1.add(queue1[i]);
            s2 += queue2[i];
            q2.add(queue2[i]);
        }
        sum = s1 + s2;
        if (sum % 2 != 0) {
            return -1;
        }
        sum /= 2;
        int i1 = 0;
        int i2 = 0;
        while (i1 <= queue1.length * 2 && i2 <= queue2.length * 2) {
            if (s1 == sum) {
                return i1 + i2;
            }
            if (s1 > sum) {
                s1 -= q1.peek();
                s2 += q1.peek();
                q2.add(q1.poll());
                i1++;
            } else if (s1 < sum) {
                s2 -= q2.peek();
                s1 += q2.peek();
                q1.add(q2.poll());
                i2++;
            }
        }
        return -1;
    }
}