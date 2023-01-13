package com.til.algorithm.baekjoon.string;

import java.io.*;

/**
 *  pkai
 *
 *  String.replace() 를 "pi" -> "ka" -> "chu" 순으로 적용하게 되면,
 *
 *  pkai -> pi -> "" 로 되면서 구성 가능한 것으로 판정하게 된다.
 */
public class BOJ_14405 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (ofPikachu(sb.toString())) {
                sb = new StringBuilder();
            }
            sb.append(S.charAt(i));
        }
        if (ofPikachu(sb.toString())) {
            sb = new StringBuilder();
        }
        if (sb.length() > 0) {
            bw.write("NO" + "\n");
        } else {
            bw.write("YES" + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean ofPikachu(String s) {
        return (s.equals("pi") || s.equals("ka") || s.equals("chu"));
    }
}