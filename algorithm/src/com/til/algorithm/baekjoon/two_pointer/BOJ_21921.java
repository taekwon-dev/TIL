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

        int maxVisitor = sum;
        int maxVisitorCount = 1;
        for (int i = X; i < N; i++) {
            sum += visitor[i] - visitor[i - X];
            if (maxVisitor < sum) {
                maxVisitor = sum;
                maxVisitorCount = 1;
                continue;
            }
            if (maxVisitor == sum) {
                maxVisitorCount++;
            }
        }

        if (maxVisitor == 0) {
            bw.write("SAD" + "\n");
        } else {
            bw.write(maxVisitor + "\n");
            bw.write(maxVisitorCount + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}