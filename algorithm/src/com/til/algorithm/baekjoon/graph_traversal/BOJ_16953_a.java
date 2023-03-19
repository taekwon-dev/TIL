package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953_a {

    private static long A;
    private static long B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs() {
        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[]{A, 1});

        while (!queue.isEmpty()) {
            long[] now = queue.poll();
            if (now[0] == B) {
                return (int) now[1];
            }
            for (int i = 0; i < 2; i++) {
                long nx = 0;
                if (i == 0) {
                    nx = now[0] * 2;
                } else if (i == 1) {
                    nx = now[0] * 10 + 1;
                }
                if (nx > B) {
                    continue;
                }
                queue.offer(new long[]{nx, now[1] + 1});
            }
        }
        return -1;
    }
}