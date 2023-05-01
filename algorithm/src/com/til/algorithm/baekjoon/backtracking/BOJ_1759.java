package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {

    private static int L;
    private static int C;
    private static char[] candidate;
    private static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        candidate = new char[C];
        answer = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            candidate[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(candidate);
        backtracking(0, 0, "");

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int start, String pwd) {
        if (depth == L) {
            if (isValid(pwd)) {
                answer.append(pwd).append("\n");
            }
            return;
        }
        for (int i = start; i < C; i++) {
            backtracking(depth + 1, i + 1, pwd + candidate[i]);
        }
    }

    private static boolean isValid(String pwd) {
        int vowel = 0;
        int consonant = 0;

        for (char c : pwd.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowel++;
            } else {
                consonant++;
            }
        }
        if (vowel >= 1 && consonant >= 2) {
            return true;
        }
        return false;
    }
}