package com.til.algorithm.leetCode.sliding_window;

import com.til.algorithm.java.data_structure.list.ArrayList;
import com.til.algorithm.java.data_structure.list.List;

import java.util.Arrays;

public class LEET_438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();
        int[] target = countChar(p);

        int left = 0;
        int right = p.length();

        while (right <= s.length()) {
            String subString = s.substring(left, right);
            int[] tempCountChar = countChar(subString);
            if (Arrays.equals(target, tempCountChar)) {
                answer.add(left);
            }
            left++;
            right++;
        }
        return answer;
    }

    private int[] countChar(String source) {
        int[] arr = new int[26];
        for (char c : source.toCharArray()) {
            arr[c - 'a']++;
        }
        return arr;
    }
}