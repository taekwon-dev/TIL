package com.til.algorithm.baekjoon.bigstone.week_2;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2870 {

    private static List<BigInteger> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            add(br.readLine());
        }
        Collections.sort(nums);
        for (BigInteger num : nums) {
            bw.write(num + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void add(String input) {
        String[] str = input.split("[^0-9]");
        for (String s : str) {
            if (s.length() == 0) {
                continue;
            }
            nums.add(new BigInteger(s));
        }
    }
}