package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_9996 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] source = br.readLine().split("\\*");
        String first = source[0];
        String last = source[1];

        for (int i = 0; i < N; i++) {
            String target = br.readLine();

            if ((first + last).length() - 1 > target.length()) {
                bw.write("NE" + "\n");
                continue;
            }
            if (target.startsWith(first) && target.endsWith(last)) {
                bw.write("DA" + "\n");
                continue;
            }
            bw.write("NE" + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}