package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15565 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> lion = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int flag = Integer.parseInt(st.nextToken());
            if (flag == 1) {
                lion.add(i);
            }
        }
        if (lion.size() < K) {
            bw.write(-1 + "\n");
        } else {
            int answer = Integer.MAX_VALUE;
            int start = 0;
            int end = K - 1;
            int count = 0;
            while (true) {
                if (end == lion.size()) {
                    break;
                }
                count = lion.get(end) - lion.get(start) + 1;
                answer = Math.min(answer, count);
                start++;
                end++;
            }

            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}