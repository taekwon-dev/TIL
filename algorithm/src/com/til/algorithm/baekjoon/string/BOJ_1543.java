package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_1543 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String source = br.readLine();
        String target = br.readLine();

        int answer = 0;

        for (int i = 0; i <= source.length() - target.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                i += target.length() - 1;
                answer++;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}