package com.til.algorithm.baekjoon.bigstone.week_5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1644 {

    private static List<Integer> prime = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        getPrimeNumber(N);

        int left = 0;
        int right = 0;
        int sum = 2;
        int answer = 0;

        while (left < prime.size() && right < prime.size()) {
            if (sum == N) {
                answer++;
                sum -= prime.get(left++);
            } else if (sum > N) {
                sum -= prime.get(left++);
            } else if (sum < N) {
                right++;
                if (right >= prime.size()) {
                    break;
                }
                sum += prime.get(right);
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void getPrimeNumber(int N) {
        int[] tmp = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            tmp[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (tmp[i] != 0) {
                for (int j = i * i; j <= N; j += i) {
                    tmp[j] = 0;
                }
            }
        }
        for (int i = 2; i <= N; i++) {
            if (tmp[i] != 0) {
                prime.add(tmp[i]);
            }
        }
    }
}