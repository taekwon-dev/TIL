package com.til.algorithm.bigstone.week_1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1629 {

    private static long c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        bw.write(pow(a, b) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static long pow(long a, long exponent) {
        if (exponent == 1) {
            return a % c;
        }
        long tmp = pow(a, exponent / 2);

        if (exponent % 2 == 1) {
            return (tmp * tmp % c) * a % c;
        }
        return tmp * tmp % c;
    }
}