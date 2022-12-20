package com.til.algorithm.programmers.kit.novice;

import java.util.ArrayList;
import java.util.List;

public class LV0_n의배수고르기 {

    public int[] solution(int n, int[] numlist) {
        List<Integer> nums = new ArrayList<>();
        for (int num : numlist) {
            if (num % n != 0) {
                continue;
            }
            nums.add(num);
        }

        int[] answer = new int[nums.size()];
        for (int idx = 0; idx < nums.size(); idx++) {
            answer[idx] = nums.get(idx);
        }
        return answer;
    }
}
