package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1940 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] weapon = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weapon[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(weapon);

        int left = 0;
        int right = weapon.length - 1;
        int answer = 0;
        while (left < right) {
            int sum = weapon[left] + weapon[right];
            if (sum == M) {
                answer++;
                left++;
                right--;
                continue;
            }
            if (sum < M) {
                left++;
            } else {
                right--;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}