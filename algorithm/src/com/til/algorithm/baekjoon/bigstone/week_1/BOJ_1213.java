package com.til.algorithm.baekjoon.bigstone.week_1;

import java.io.*;

/**
 *  Palindrome 판정에서도 생각해본 내용
 *
 *  문자열의 길이를 기준 (짝수 / 홀수)으로 나눠서 생각해볼 수 있다.
 *
 *  ㄱ) 짝수
 *  - 등장한 알파벳은 모두 짝수개고, 개수가 모두 동일해야 한다.
 *  - front + end 로 구성할 수 있다.
 *      - front 는 등장한 각 문자를 하나씩 조합해서 만든다.
 *      - end 는 front 를 역순서로 구성해서 만든다.
 *
 *  ㄴ) 홀수
 *  - 등장한 알파벳의 개수가 홀수개인 수는 오직 하나여야 한다. (= 대칭 역할)
 *  - front + mid + end
 *      - front, end 짝수 경우와 동일
 *      - mid 는 알파벳의 개수가 홀수개인 것을 통해 만든다.
 */
public class BOJ_1213 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] alphabet = new int[26];
        String s = br.readLine();
        for (char c : s.toCharArray()) {
            alphabet[c - 'A']++;
        }

        int isOne = 0;
        for (int count : alphabet) {
            if (count % 2 != 0) {
                isOne++;
            }
        }
        if (isOne > 1) {
            write("I'm Sorry Hansoo");
            return;
        }

        String answer = null;
        StringBuilder front = new StringBuilder();
        for (int i = 0; i < alphabet.length; i++) {
            for (int j = 0; j < alphabet[i] / 2; j++) {
                front.append((char) (i + 'A'));
            }
        }
        answer = front.toString();
        String end = front.reverse().toString();
        StringBuilder mid = new StringBuilder();
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] % 2 == 1) {
                mid.append((char) (i + 'A'));
            }
        }
        answer += (mid.toString() + end);
        write(answer);
    }

    private static void write(String s) throws IOException {
        bw.write(s + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}