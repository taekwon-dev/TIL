package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_9342 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            if (infected(br.readLine())) {
                bw.write("Infected!" + "\n");
                continue;
            }
            bw.write("Good" + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean infected(String test) {
        if (!test.startsWith("A") &&
            !test.startsWith("AA") &&
            !test.startsWith("BA") &&
            !test.startsWith("CA") &&
            !test.startsWith("DA") &&
            !test.startsWith("EA") &&
            !test.startsWith("FA")
        ) {
             return false;
        }
        if (!test.endsWith("C") &&
            !test.endsWith("CA") &&
            !test.endsWith("CB") &&
            !test.endsWith("CC") &&
            !test.endsWith("CD") &&
            !test.endsWith("CE") &&
            !test.endsWith("CF")
        ) {
            return false;
        }
        int indexOfF = test.indexOf('F');
        for (int i = 2; i < indexOfF; i++) {
            if (test.charAt(i) != 'A') {
                return false;
            }
        }
        int indexOfC = test.indexOf('C', indexOfF + 1);
        for (int f = indexOfF + 1; f < indexOfC; f++) {
            if (test.charAt(f) != 'F') {
                return false;
            }
        }
        return true;
    }
}