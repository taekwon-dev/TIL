package com.til.algorithm.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/02.
 * Title : 공약수 (https://www.acmicpc.net/problem/5618)
 * Hint  : 공약수 찾는 대상 중 가장 작은 수의 약수를 기준으로 문제 풀기
 */
public class BOJ_5618 {

    static int n;
    static ArrayList<Integer> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(nums);

        for (int i = 1; i < nums.get(0) + 1; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums.get(j) % i == 0) {
                    count++;
                }
            }
            if (count == n) {
                System.out.println(i);
            }
        }
    }
}
