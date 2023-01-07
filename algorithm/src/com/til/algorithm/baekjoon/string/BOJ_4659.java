package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while (!(input = br.readLine()).equals("end")) {
            if (validate(input)) {
                bw.write("<" + input + "> is acceptable." + "\n");
                continue;
            }
            bw.write("<" + input + "> is not acceptable." + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean validate(String password) {
        boolean vowelFlag = false;
        int vowels = 0;
        int consonants = 0;
        char prev = 'A';
        for (char c : password.toCharArray()) {
            if (isVowel(c)) {
                vowelFlag = true;
                consonants = 0;
                if (++vowels == 3) {
                    return false;
                }
            } else {
                vowels = 0;
                if (++consonants == 3) {
                    return false;
                }
            }
            if (prev == c && (c != 'e' && c != 'o')) {
                return false;
            }
            prev = c;
        }
        if (!vowelFlag) {
            return false;
        }
        return true;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}