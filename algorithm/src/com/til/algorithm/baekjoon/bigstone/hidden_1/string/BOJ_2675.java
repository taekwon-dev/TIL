package com.til.algorithm.baekjoon.bigstone.hidden_1.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2675 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int r = 0;
        StringTokenizer st = null;
        String word = null;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            word = st.nextToken();

            for (int i = 0; i < word.length(); i++) {
                for (int j = 0; j < r; j++) {
                    sb.append(word.charAt(i));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}