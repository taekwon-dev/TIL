package com.til.algorithm.leetCode.sliding_window;

public class LEET_567 {

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2) {
            return false;
        }
        int[] map = new int[26];
        for (int i = 0; i < len1; i++) {
            map[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len2; i++) {
            map[s2.charAt(i) - 'a']--;
            if (i - len1 >= 0) {
                map[s2.charAt(i - len1) - 'a']++;
            }
            if (isPermutation(map)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPermutation(int[] map) {
        boolean result = true;
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}