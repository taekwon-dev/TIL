package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ_1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }

        long answer = 0;
        while (pq.size() >= 2) {
            long o1 = pq.poll();
            long o2 = pq.poll();

            answer += o1 + o2;
            pq.add(o1 + o2);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
