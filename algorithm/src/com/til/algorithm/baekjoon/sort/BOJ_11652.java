package com.til.algorithm.baekjoon.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BOJ_11652 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int max = 0;
        long answer = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long key = Long.parseLong(br.readLine());
            map.put(key, map.getOrDefault(key, 0) + 1);

            if (max < map.get(key)) {
                max = map.get(key);
                answer = key;
                continue;
            }
            if (max == map.get(key)) {
                answer = Math.min(answer, key);
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}