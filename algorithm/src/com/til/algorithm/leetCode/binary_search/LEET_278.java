package com.til.algorithm.leetCode.binary_search;

public class LEET_278 {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            /**
             *  (Left + Right) / 2 = OverFlow 고려해서 아래와 같이 대처 가능
             */
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int target) {
        return false;
    }
}