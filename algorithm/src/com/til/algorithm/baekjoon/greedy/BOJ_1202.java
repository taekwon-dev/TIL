package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202 {

    static class Jewel {
        int mass;
        int value;

        Jewel(int mass, int value) {
            this.mass = mass;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Jewel[] jewels = new Jewel[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(M, V);
        }

        Arrays.sort(jewels, (o1, o2) -> {
            if (o1.mass == o2.mass) {
                return o2.value - o1.value;
            }
            return o1.mass - o2.mass;
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
            while (j < N && jewels[j].mass <= bag[i]) {
                pq.offer(jewels[j].value);
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