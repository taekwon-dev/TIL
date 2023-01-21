package com.til.algorithm.bigstone.week_3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9934 {

    private static int K;
    private static int[] arr;
    private static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = (int) Math.pow(2, K) - 1;
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        adjList = new ArrayList[K];
        for (int i = 0; i < K; i++) {
            adjList[i] = new ArrayList<>();
        }
        inorder(0, 0, arr.length - 1);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < K; i++) {
            for (int node : adjList[i]) {
                answer.append(node + " ");
            }
            answer.append("\n");
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void inorder(int depth, int left, int right) {
        if (left > right) {
            return;
        }
        int mid = (left + right) / 2;
        inorder(depth + 1, left, mid - 1);
        adjList[depth].add(arr[mid]);
        inorder(depth + 1, mid + 1, right);
    }
}