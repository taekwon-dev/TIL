package com.til.algorithm.baekjoon.sort;

import java.io.*;
import java.util.Arrays;

public class BOJ_1431 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] guitar = new String[N];

        for (int i = 0; i < N; i++) {
            guitar[i] = br.readLine();
        }

        Arrays.sort(guitar, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                int o1Sum = sum(o1);
                int o2Sum = sum(o2);
                if (o1Sum == o2Sum) {
                    return o1.compareTo(o2);
                }
                return o1Sum - o2Sum;
            }
            return o1.length() - o2.length();
        });

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            answer.append(guitar[i]).append("\n");
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int sum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                continue;
            }
            sum += c - '0';
        }
        return sum;
    }
}