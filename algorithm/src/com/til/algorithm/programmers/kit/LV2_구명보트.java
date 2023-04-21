package com.til.algorithm.programmers.kit;

import java.util.Arrays;

public class LV2_구명보트 {

    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;
        int i = 0;
        int j = people.length - 1;
        while (i <= j) {
            if (i == j) {
                answer++;
                break;
            }
            int sum = people[i] + people[j];
            if (sum > limit) {
                j--;
            } else if (sum <= limit) {
                i++;
                j--;
            }
            answer++;
        }

        return answer;
    }
}