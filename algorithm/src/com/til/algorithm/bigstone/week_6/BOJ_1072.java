package com.til.algorithm.bigstone.week_6;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1072 {

    private static long X;
    private static long Y;
    private static long Z;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        Z = Y * 100 / X;
        if (Z >= 99) {
            bw.write(-1 + "\n");
        } else {
            bw.write(binarySearch(1, X) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static long binarySearch(long left, long right) {
        long mid = 0;
        long rate = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            rate = (Y + mid) * 100 / (X + mid);
            if (rate > Z) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}