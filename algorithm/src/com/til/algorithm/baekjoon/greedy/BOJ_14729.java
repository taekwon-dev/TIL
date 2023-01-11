package com.til.algorithm.baekjoon.greedy;

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
            double tmp = Double.parseDouble(br.readLine());
            if (pq.size() >= 7) {
                if (pq.peek() > tmp) {
                    pq.poll();
                    pq.offer(tmp);
                }
                continue;
            }
            pq.offer(tmp);
        }

        LinkedList<Double> linkedList = new LinkedList<>();
        while (N-- > 1) {
            linkedList.addFirst(pq.poll());
        }

        for (int i = 0; i < 7; i++) {
            bw.write(String.format("%.3f", linkedList.get(i)) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}