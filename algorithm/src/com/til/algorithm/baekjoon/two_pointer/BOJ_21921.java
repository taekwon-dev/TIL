package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_21921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] visitor = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visitor[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += visitor[i];
        }
        int max = 0;
        int maxCount = 1;
        for (int i = X; i < N; i++) {
            sum += visitor[i] - visitor[i - X];
            if (max == sum) {
                maxCount++;
                continue;
            }
            if (max < sum) {
                max = sum;
                maxCount = 1;
            }
        }

        if (max == 0) {
            bw.write("SAD" + "\n");
        } else {
            bw.write(max + "\n");
            bw.write(maxCount + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}