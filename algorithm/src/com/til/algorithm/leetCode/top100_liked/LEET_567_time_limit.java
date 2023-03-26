package com.til.algorithm.leetCode.top100_liked;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LEET_567_time_limit {

    private char[] s;
    private boolean[] visited;
    private Set<String> set = new HashSet<>();

    public boolean checkInclusion(String s1, String s2) {
        s = s1.toCharArray();
        Arrays.sort(s);
        visited = new boolean[s1.length()];
        backtracking(0, "");
        for (String target : set) {
            if (s2.contains(target)) {
                return true;
            }
        }
        return false;
    }

    private void backtracking(int depth, String candidate) {
        if (depth == s.length) {
            set.add(candidate);
            return;
        }
        char prev = 'A';
        for (int i = 0; i < s.length; i++) {
            if (!visited[i] && prev != s[i]) {
                prev = s[i];
                visited[i] = true;
                backtracking(depth + 1, candidate + s[i]);
                visited[i] = false;
            }
        }
    }
}
