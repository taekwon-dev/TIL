package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_20154 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] val = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
        String S = br.readLine();
        int answer = 0;
        for (int i = 0; i < S.length(); i++) {
            answer += val[S.charAt(i) - 'A'];
        }
        answer %= 10;
        if (answer % 2 == 0) {
            bw.write("You're the winner?" + "\n");
        } else {
            bw.write("I'm a winner!" + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}