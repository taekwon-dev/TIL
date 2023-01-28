package com.til.algorithm.bigstone.hidden_1.sort;

import java.io.*;
import java.util.Arrays;

public class BOJ_1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] input = br.readLine().toCharArray();
        Arrays.sort(input);

        StringBuilder sb = new StringBuilder();
        for (int idx = input.length - 1; idx >= 0; idx--) {
            sb.append(input[idx]);
        }

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}