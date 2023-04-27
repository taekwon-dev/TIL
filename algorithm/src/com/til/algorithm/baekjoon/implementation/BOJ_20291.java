package com.til.algorithm.baekjoon.implementation;

import java.io.*;
import java.util.TreeMap;

public class BOJ_20291 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> map = new TreeMap<>();
        while (N-- > 0) {
            String exe = br.readLine().split("\\.")[1];
            map.put(exe, map.getOrDefault(exe, 0) + 1);
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