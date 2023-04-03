package com.til.algorithm.baekjoon.implementation;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class BOJ_20291 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = new TreeMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String fileExt = br.readLine().split("\\.")[1];
            map.put(fileExt, map.getOrDefault(fileExt, 0) + 1);
        }
        StringBuilder answer = new StringBuilder();
        map.forEach((k, v) -> {
            answer.append(k + " " + v).append("\n");
        });

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}