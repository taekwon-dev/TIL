package com.til.algorithm.baekjoon.implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_9934 {

    private static int K;
    private static int[] arr;
    private static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());
        int len = (int) Math.pow(2, K) - 1;
        arr = new int[len];
        adjList = new ArrayList[K];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < K; i++) {
            adjList[i] = new ArrayList<>();
        }

        inorder(0, 0, arr.length - 1);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < adjList.length; i++) {
            for (int j = 0; j < adjList[i].size(); j++) {
                answer.append(adjList[i].get(j)).append(" ");
            }
            answer.append("\n");
        }

        bw.write(answer.toString() + "\n");
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