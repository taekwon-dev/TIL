package com.til.algorithm.leetCode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Sliding Window for Anagram
 */
public class LEET_438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] anagram = countChar(p);

        int left = 0;
        int right = p.length();

        while (right <= s.length()) {
            String temp = s.substring(left, right);
            int[] tempCountChar = countChar(temp);
            if (Arrays.equals(anagram, tempCountChar)) {
                result.add(left);
            }
            left++;
            right++;
        }
        return result;
    }

    private int[] countChar(String target) {
        int[] arr = new int[26];
        for (char c : target.toCharArray()) {
            arr[c - 'a']++;
        }
        return arr;
    }
}