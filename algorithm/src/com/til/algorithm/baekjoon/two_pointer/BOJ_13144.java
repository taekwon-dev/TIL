package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13144 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] cnt = new int[100_000 + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        int i = 1;
        int j = 0;
        while (i <= N) {
            while (j + 1 <= N && cnt[arr[j + 1]] == 0) {
                j++;
                cnt[arr[j]]++;
            }
            answer += j - i + 1;
            cnt[arr[i]]--;
            i++;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}