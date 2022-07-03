package com.til.algorithm.programmers.brute_force;

import java.util.ArrayList;

/**
 * Created by Youn on 2022/06/18.
 * Title : 모의고사 (https://programmers.co.kr/learn/courses/30/lessons/42840)
 * Hint  :
 */
public class LV1_모의고사 {
    public int[] s1 = {1, 2, 3, 4, 5};
    public int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
    public int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int s1_count = 0;
        int s2_count = 0;
        int s3_count = 0;
        for (int i = 0; i < answers.length; i++) {
            if (s1[i % s1.length] == answers[i]) {
                s1_count += 1;
            }

            if (s2[i % s2.length] == answers[i]) {
                s2_count += 1;
            }

            if (s3[i % s3.length] == answers[i]) {
                s3_count += 1;
            }
        }
        int max = Math.max(Math.max(s1_count, s2_count), s3_count);
        ArrayList<Integer> students = new ArrayList<>();
        if (max == s1_count) {
            students.add(1);
        }

        if (max == s2_count) {
            students.add(2);
        }

        if (max == s3_count) {
            students.add(3);
        }
        answers = new int[students.size()];
        for (int i = 0; i < students.size(); i++) {
            answers[i] = students.get(i);
        }
        return answers;
    }
}
