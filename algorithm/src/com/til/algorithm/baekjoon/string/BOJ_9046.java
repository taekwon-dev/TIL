package com.til.algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Youn on 2022/06/03.
 * Title : 복호화 (https://www.acmicpc.net/problem/9046)
 * Hint  : char to int
 *
 *    '0' = 48
 *    '1' = 49
 *    '2' = 50
 *    .
 *    .
 *    .
 *    '9' = 57
 *
 *    (char) (int + 'a')
 */
public class BOJ_9046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            String text = br.readLine();
            int[] alphabets = new int[26];
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
                    alphabets[text.charAt(i) - 'a']++;
                }
            }
            int max = 0;
            for (int alphabet : alphabets) {
                if (alphabet > max) {
                    max = alphabet;
                }
            }
            int count = 0;
            int result = 0;
            for (int i = 0; i < 26; i++) {
                if (max == alphabets[i]) {
                    count++;
                    result = i;
                }
            }
            System.out.println(count == 1 ? (char) result + 'a' : '?');
        }
    }
}
