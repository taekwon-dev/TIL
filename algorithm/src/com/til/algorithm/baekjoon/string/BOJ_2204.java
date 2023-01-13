package com.til.algorithm.baekjoon.string;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  문자열 정렬 + (대/소문자 무시)
 */
public class BOJ_2204 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = 0;
        List<String> words;
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            words = new ArrayList<>(N);
            while (N-- > 0) {
                words.add(br.readLine());
            }
            Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
            bw.write(words.get(0) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}