package com.til.algorithm.baekjoon.bigstone.week_1;

import java.io.*;
import java.util.*;

public class BOJ_1620_time_out {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> pocketmon = new LinkedHashMap<>();
        int idx = 1;
        while (n-- > 0) {
            pocketmon.put(String.valueOf(idx++), br.readLine());
        }

        List<String> names = new ArrayList<>(pocketmon.values());
        String quiz = null;
        while (m-- > 0) {
            quiz = br.readLine();
            if (pocketmon.containsKey(quiz)) {
                bw.write(pocketmon.get(quiz) + "\n");
                continue;
            }
            bw.write(names.indexOf(quiz) + 1 + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}