package com.til.algorithm.programmers.kit;

import java.util.HashSet;
import java.util.Set;

public class LV1_포켓몬 {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int num : nums) {
            set.add(num);
        }
        int answer = 0;
        if (set.size() > len / 2) {
            answer = len / 2;
        } else {
            answer = set.size();
        }
        return answer;
    }
}
