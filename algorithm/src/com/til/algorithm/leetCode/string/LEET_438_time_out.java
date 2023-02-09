package com.til.algorithm.leetCode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *  s = "aaaaaaaaaa"
 *  p = "aaaaaaaaaaaaa"
 */
public class LEET_438_time_out {

    private HashSet<String> anagrams = new HashSet<>();
    private boolean[] used;

    public List<Integer> findAnagrams(String s, String p) {
        used = new boolean[p.length()];
        backtracking(0, p, "");

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            String target = s.substring(i, i + p.length());
            if (anagrams.contains(target)) {
                answer.add(i);
            }
        }
        return answer;
    }

    private void backtracking(int depth, String p, String anagram) {
        if (depth == p.length()) {
            anagrams.add(anagram);
            return;
        }
        for (int i = 0; i < p.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                backtracking(depth + 1, p, anagram + p.charAt(i));
                used[i] = false;
            }
        }
    }
}
