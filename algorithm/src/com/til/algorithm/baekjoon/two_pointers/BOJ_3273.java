package com.til.algorithm.baekjoon.two_pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/09.
 * Title : 두 수의 합 (https://www.acmicpc.net/problem/3273)
 * Hint  :
 */
public class BOJ_3273 {

    static int n, x;
    static int result = 0;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());

        Arrays.sort(nums);

        int start = 0, end = n-1;

        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == x) {
                result += 1;
                start += 1;
                end -= 1;
            } else if (sum > x) {
                end -= 1;
            } else if (sum < x) {
                start += 1;
            }
        }
        System.out.println(result);


    }
}
