package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;
import java.util.*;

public class BOJ_21921_time_out {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] visitor = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            visitor[n] = Integer.parseInt(st.nextToken());
        }

        List<Integer> visitors = new ArrayList<>();
        for (int i = 0; i < N - X + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + X; j++) {
                sum += visitor[j];
            }
            visitors.add(sum);
        }

        int max = Collections.max(visitors);
        if (max == 0) {
            bw.write("SAD");
        } else {
            int count = 0;
            for (int cnt : visitors) {
                if (cnt == max) {
                    count++;
                }
            }

            bw.write(max + "\n");
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}