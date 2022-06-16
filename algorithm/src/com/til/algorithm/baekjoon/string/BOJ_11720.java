package com.til.algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Youn on 2022/06/03.
 * Title : 숫자의 합 (https://www.acmicpc.net/problem/11720)
 * Hint  :
 */
public class BOJ_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        String num = br.readLine();
        int nums[] = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = num.charAt(i) - '0';
            result += nums[i];
        }
        System.out.println(result);
    }
}
