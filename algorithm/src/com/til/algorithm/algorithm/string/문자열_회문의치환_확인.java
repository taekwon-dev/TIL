package com.til.algorithm.algorithm.string;

/**
 *  회문 (= Palindrome)
 *  치환 (= Permutation)
 */
public class 문자열_회문의치환_확인 {

    public static void main(String[] args) {
        System.out.println(isPermutationOfPalindrome("aa bb cc dd"));        // true
        System.out.println(isPermutationOfPalindrome("aa bb cc dd e"));      // true
        System.out.println(isPermutationOfPalindrome("aa bb cc dd e fff"));  // false


        System.out.println(isPermutationOfPalindrome2("aa bb cc dd"));        // true
        System.out.println(isPermutationOfPalindrome2("aa bb cc dd e"));      // true
        System.out.println(isPermutationOfPalindrome2("aa bb cc dd e fff"));  // false
    }

    private static boolean isPermutationOfPalindrome(String s) {
        int[] table = buildCharFrequencyTable(s);
        return checkMaxOneOdd(table);
    }

    private static boolean isPermutationOfPalindrome2(String s) {
        int countOdd = 0;
        int[] table = new int[(int) 'z' - (int) 'a' + 1];
        for (char c : s.toCharArray()) {
            int idx = getCharNumber(c);
            if (idx != -1) {
                table[idx]++;
                if (table[idx] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    private static int[] buildCharFrequencyTable(String s) {
        int[] table = new int[(int) 'z' - (int) 'a' + 1];
        for (char c : s.toCharArray()) {
            int idx = getCharNumber(c);
            if (idx != -1) {
                table[idx]++;
            }
        }
        return table;
    }

    private static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    private static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (!foundOdd) {
                    foundOdd = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}