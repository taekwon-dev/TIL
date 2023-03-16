package com.til.algorithm.leetCode.string;

/**
 *  You must do this by modifying the input array in-place with O(1) extra memory. (제자리 정렬)
 */
public class LEET_344 {

    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i <= j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}