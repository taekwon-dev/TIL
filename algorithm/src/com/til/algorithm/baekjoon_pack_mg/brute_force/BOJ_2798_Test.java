package com.til.algorithm.baekjoon_pack_mg.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/17.
 * Title : 블랙잭 (https://www.acmicpc.net/problem/2798)
 * Hint  : 5, 6, 7, 8, 9 5C3 = 10 를 뽑는 방법 -> 3 for loop
 */
public class BOJ_2798_Test {
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
        System.out.println(brute_force());
    }

    private static int brute_force() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > m) continue;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] > m) continue;
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (sum == m) return sum;

                    if (max < sum && sum < m) {
                        max = sum;
                    }
                }
            }
        }
        return max;
    }
}
