package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16953_b {

    private static int A;
    private static int B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int answer = 1;
        while (B != A) {
            if (B < A) {
                answer = -1;
                break;
            }
            String s = String.valueOf(B);
            if (s.charAt(s.length() - 1) != '1' && B % 2 != 0) {
                answer = -1;
                break;
            }
            if (B % 2 == 0) {
                B >>= 1;
            } else {
                s = s.substring(0, s.length() - 1);
                B = Integer.parseInt(s);
            }
            answer++;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}