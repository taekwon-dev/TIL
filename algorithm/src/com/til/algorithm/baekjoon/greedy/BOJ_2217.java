package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> maxWeights = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            maxWeights.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(maxWeights);
        int max = 1;
        for (int i = 0; i < maxWeights.size(); i++) {
            max = Math.max(max, maxWeights.get(i) * (n - i));
        }
        System.out.println(max);
    }
}
