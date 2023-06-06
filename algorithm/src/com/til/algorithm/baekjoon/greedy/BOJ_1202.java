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
            int mass = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewel[i][0] = mass;
            jewel[i][1] = value;
        }

        Arrays.sort(jewel, (o1, o2) -> {
            // 보석의 무게가 같은 경우
            if (o1[0] == o2[0]) {
                // 보석의 가치를 기준으로 내림차순 적용
                return o2[1] - o1[1];
            }
            // 보석의 무게를 기준으로 오름차순 적용
            return o1[0] - o2[0];
        });

        int[] bag = new int[K];
        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;
        int j = 0;
        for (int i = 0; i < K; i++) {
            while (j < N && jewel[j][0] <= bag[i]) {
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