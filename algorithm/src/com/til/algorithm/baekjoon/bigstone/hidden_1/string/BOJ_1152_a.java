package com.til.algorithm.baekjoon.bigstone.hidden_1.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1152_a {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        int count = 0;
        for (String word : sentence.split(" ")) {
            if (word.length() > 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}