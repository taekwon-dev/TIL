package com.til.algorithm.baekjoon.sort;

import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class BOJ_14729 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            if (pq.size() == 7) {
                pq.offer(Double.parseDouble(br.readLine()));
                pq.poll();
            } else {
                pq.offer(Double.parseDouble(br.readLine()));
            }
        }
        LinkedList<Double> low = new LinkedList<>();

        while (!pq.isEmpty()) {
            low.addFirst(pq.poll());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            sb.append(String.format("%.3f", low.get(i))).append("\n");
        }
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}