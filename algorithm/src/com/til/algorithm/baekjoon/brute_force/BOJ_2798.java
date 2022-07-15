package com.til.algorithm.baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  블랙잭
 *
 *  조합 = 순서를 고려하지 않는다.
 *
 *  [1, 2, 3, 4, 5]
 *
 *  1 + 2 + 3
 *  1 + 2 + 4
 *  1 + 2 + 5
 *  1 + 3 + 4
 *  .
 *  .
 *  .
 *
 */
public class BOJ_2798 {
    static int n, m;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > m) continue;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] > m) continue;
                for (int k = j + 1; k < n; k++) {
                    if ((nums[i] + nums[j] + nums[k]) <= m) {
                        max = Math.max(max, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }
        System.out.println(max);
    }

}
