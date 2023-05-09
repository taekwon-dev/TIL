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

        public Jewel(int mass, int value) {
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
            jewels[i].mass = Integer.parseInt(st.nextToken());
            jewels[i].value = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(jewels, (o1, o2) -> {
            if (o1.mass == o2.mass) {
                return o2.value - o1.value;
            }
            return o1.mass - o2.mass;
        });
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        for (int i = 0; i < K; i++) {
            while (j < N && jewels[j].mass <= bags[i]) {
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