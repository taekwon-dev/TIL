package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        List<Integer> maxWeights = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            maxWeights.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(maxWeights);

        int max = maxWeights.get(maxWeights.size() - 1);
        for (int i = 0; i < maxWeights.size(); i++) {
            if (maxWeights.get(i) * (N - i) > max) {
                max = maxWeights.get(i) * (N - i);
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}