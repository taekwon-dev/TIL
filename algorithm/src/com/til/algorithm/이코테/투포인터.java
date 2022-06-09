package com.til.algorithm.이코테;

/**
 * Created by Youn on 2022/06/09.
 * Title : 투포인터 예시 문제 - 특정한 합을 가지는 부분 연속 수열 찾기
 * Hint  :
 */
public class 투포인터 {
    public static int n = 5;
    public static int m = 5;
    public static int[] arr = {1, 2, 3, 2, 5};

    public static void main(String[] args) {
        int cnt = 0, intervalSum = 0, end = 0;
        for (int start = 0; start < n; start++) {
            while (intervalSum < m && end < n) {
                intervalSum += arr[end];
                end += 1;
            }
            if (intervalSum == m) {
                cnt++;
            }
            intervalSum -= arr[start];
        }
        System.out.println(cnt);
    }
}
