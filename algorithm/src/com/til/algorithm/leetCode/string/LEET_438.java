package com.til.algorithm.leetCode.string;

import java.util.ArrayList;
import java.util.List;

/**
 *  Sliding Window for Anagram
 */
public class LEET_438 {

    public static void main(String[] args) {
        List<Integer> answer = findAnagrams("abracadabra", "abr");
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();
        int lenS = s.length();
        int lenP = p.length();
        int[] alphabet = new int[26];
        for (int i = 0; i < lenP; i++) {
            alphabet[p.charAt(i) - 'a']++;
        }

        int start = 0;
        for (int i = 0; i < lenS; i++) {
            alphabet[s.charAt(i) - 'a']--;
            if (i - start >= lenP) {
                alphabet[s.charAt(start++) - 'a']++;
            }
            if (isAllZero(alphabet)) {
                answer.add(start);
            }
        }
        return answer;
    }

    private static boolean isAllZero(int[] alphabet) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] != 0) {
                return false;
            }
        }
        return true;
    }
}