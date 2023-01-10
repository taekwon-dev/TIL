package com.til.algorithm.baekjoon.bigstone.week_5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int X = Integer.parseInt(br.readLine());
        int answer = 0;

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == X) {
                left++;
                right--;
                answer++;
                continue;
            }
            if (sum > X) {
                right--;
                continue;
            }
            left++;
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
