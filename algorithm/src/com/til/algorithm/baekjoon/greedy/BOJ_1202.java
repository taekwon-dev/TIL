package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] jewel = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewel[i][0] = Integer.parseInt(st.nextToken()); // 무게
            jewel[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }
        Arrays.sort(jewel, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int[] weight = new int[K];
        for (int i = 0; i < K; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(weight);

        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        for (int i = 0; i < K; i++) {
            while (j < N && jewel[j][0] <= weight[i]) {
                pq.offer(jewel[j][1]);
                j++;
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}