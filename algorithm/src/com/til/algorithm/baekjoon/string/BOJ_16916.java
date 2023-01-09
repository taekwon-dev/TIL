package com.til.algorithm.baekjoon.string;

import java.io.*;

/**
 *  KMP(Knuth + Morris + Prett) O(N + M)
 */
public class BOJ_16916 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String P = br.readLine();
        String S = br.readLine();
        bw.write(KMP(P, S) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int KMP(String P, String S) {
        int[] table = makeTable(S);
        int PL = P.length();
        int SL = S.length();

        int idx = 0;
        for (int i = 0; i < PL; i++) {
            while (idx > 0 && P.charAt(i) != S.charAt(idx)) {
                idx = table[idx - 1];
            }
            if (P.charAt(i) == S.charAt(idx)) {
                if (idx == SL - 1) {
                    // parent 의 모든 범위에서 검색할 때
                    idx = table[idx];
                    return 1;
                } else {
                    idx += 1;
                }
            }
        }
        return 0;
    }

    private static int[] makeTable(String S) {
        int n = S.length();
        int[] table = new int[n];

        int idx = 0;
        for (int i = 1; i < n; i++) {
            while (idx > 0 && S.charAt(i) != S.charAt(idx)) {
                idx = table[idx - 1];
            }
            if (S.charAt(i) == S.charAt(idx)) {
                idx += 1;
                table[i] = idx;
            }
        }
        return table;
    }
}