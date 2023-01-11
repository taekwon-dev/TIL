package com.til.algorithm.bigstone.week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2979 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] time = new int[101];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int in = Integer.parseInt(st.nextToken());
            int out = Integer.parseInt(st.nextToken());
            for (int j = in; j < out; j++) {
                time[j + 1]++;
            }
        }
        int sum = 0;
        for (int i = 0; i < 101; i++) {
            if (time[i] == 0) {
                continue;
            }
            if (time[i] == 1) {
                sum += time[i] * a;
                continue;
            }
            if (time[i] == 2) {
                sum += time[i] * b;
                continue;
            }
            if (time[i] == 3) {
                sum += time[i] * c;
                continue;
            }
        }
        System.out.println(sum);
    }
}
