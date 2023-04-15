package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] lecture = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lecture[i][0] = start;
            lecture[i][1] = end;
        }

        Arrays.sort(lecture, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lecture[0][1]);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= lecture[i][0]) {
                pq.poll();
            }
            pq.add(lecture[i][1]);
        }

        bw.write(pq.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}