package com.til.algorithm.bigstone.week_3;

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
        int size = (int) (Math.pow(2, K) - 1);
        arr = new int[size];
        adjList = new ArrayList[K];

        for (int i = 0; i < K; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        inorder(0, 0, size - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < adjList.length; i++) {
            for (int j = 0; j < adjList[i].size(); j++) {
                sb.append(adjList[i].get(j)).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString() + "\n");
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