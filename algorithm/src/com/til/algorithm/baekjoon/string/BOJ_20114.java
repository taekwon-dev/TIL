package com.til.algorithm.baekjoon.string;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20114 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        char[] answer = new char[N];
        Arrays.fill(answer, '?');
        for (int i = 0; i < H; i++) {
            String row = br.readLine();
            for (int j = 0; j < N * W; j++) {
                char c = row.charAt(j);
                if (c == '?') {
                    continue;
                }
                answer[j / W] = c;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : answer) {
            sb.append(c);
        }

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}