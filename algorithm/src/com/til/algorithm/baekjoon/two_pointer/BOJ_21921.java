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

        int visit = 0;
        for (int i = 0; i < X; i++) {
            visit += visitor[i];
        }
        int max = visit;
        int maxCnt = 1;
        for (int i = X; i < N; i++) {
            visit += visitor[i] - visitor[i - X];
            if (max == visit) {
                maxCnt++;
                continue;
            }
            if (max < visit) {
                max = visit;
                maxCnt = 1;
            }
        }

        if (max == 0) {
            bw.write("SAD" + "\n");
        } else {
            bw.write(max + "\n");
            bw.write(maxCnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}