package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_16916_time_out {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String P = br.readLine();
        String S = br.readLine();
    }

    /**
     *  시간 초과
     */
    private static boolean contains(String P, String S) {
        return P.contains(S);
    }

    /**
     *  시간 초과 O(N * M)
     */
    private static boolean implementation(String P, String S) {
        int PL = P.length();
        int SL = S.length();

        for (int i = 0; i <= PL - SL; i++) {
            for (int j = 0; j < SL; j++) {
                if (P.charAt(i + j) != S.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}