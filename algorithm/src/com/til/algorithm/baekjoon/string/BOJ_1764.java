package com.til.algorithm.baekjoon.string;

import java.io.*;
import java.util.*;

public class BOJ_1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> names = new HashSet<>();
        while (N-- > 0) {
            names.add(br.readLine());
        }

        List<String> answer = new ArrayList<>();
        while (M-- > 0) {
            String name = br.readLine();
            if (names.contains(name)) {
                answer.add(name);
            }
        }
        Collections.sort(answer, Comparator.naturalOrder());

        bw.write(answer.size() + "\n");
        for (String name : answer) {
            bw.write(name + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}