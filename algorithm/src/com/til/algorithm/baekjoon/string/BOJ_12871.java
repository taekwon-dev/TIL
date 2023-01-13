package com.til.algorithm.baekjoon.string;

import java.io.*;

/**
 *  최소 공배수
 */
public class BOJ_12871 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        String T = br.readLine();

        int sLen = S.length();
        int tLen = T.length();
        int lcm = LCM(sLen, tLen, GCD(sLen, tLen));

        StringBuilder sBuilder = new StringBuilder(S);
        StringBuilder tBuilder = new StringBuilder(T);
        while (sBuilder.length() != lcm) {
            sBuilder.append(S);
        }
        while (tBuilder.length() != lcm) {
            tBuilder.append(T);
        }
        if (sBuilder.toString().equals(tBuilder.toString())) {
            bw.write("1" + "\n");
        } else {
            bw.write("0" + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    private static int LCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}