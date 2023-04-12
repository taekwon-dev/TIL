package com.til.algorithm.baekjoon.prefix_sum;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        long answer = 0;
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (arr[i] == K) {
                answer++;
            }
            count = map.getOrDefault(arr[i] - K, 0);
            answer += (long) count;
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}