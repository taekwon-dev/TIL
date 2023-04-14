package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18513 {

    private static int N;
    private static int K;
    private static long answer;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        bfs();

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            queue.offer(arr[i]);
            set.add(arr[i]);
        }
        int dist = 1;

        outer:
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                int left = now - 1;
                int right = now + 1;

                if (!set.contains(left)) {
                    queue.offer(left);
                    set.add(left);
                    answer += dist;
                    if (--K == 0) {
                        break outer;
                    }
                }

                if (!set.contains(right)) {
                    queue.offer(right);
                    set.add(right);
                    answer += dist;
                    if (--K == 0) {
                        break outer;
                    }
                }
            }
            dist++;
        }
    }
}