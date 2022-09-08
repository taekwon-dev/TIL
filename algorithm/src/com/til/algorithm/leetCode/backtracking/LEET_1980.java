package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *  Find Unique Binary String
 */
public class LEET_1980 {
    String answer;
    public String findDifferentBinaryString(String[] nums) {
        List<String> list = new ArrayList<>();
        backtracking(nums, list, 0, "");


        for (String str : list) {
            boolean flag = false;
            for (String target : nums) {
                if (str.equals(target)) {
                    flag = false;
                    break;
                }
                flag = true;
            }
            if (flag) {
                answer = str;
                break;
            }

        }

        return answer;
    }

    private void backtracking(String[] nums, List<String> list, int depth, String s) {
        if (depth == nums.length) {
            list.add(s);
            return;
        }
        for (int i = 0; i < 2; i++) {
            backtracking(nums, list, depth + 1, s + i);
        }
    }
}
