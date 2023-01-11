package com.til.algorithm.bigstone.week_3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9934 {

    private static int[] nodes;
    private static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());
        int size = (int) Math.pow(2, K) - 1;

        nodes = new int[size];
        adjList = new ArrayList[K];
        for (int i = 0; i < K; i++) {
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
        }
        solution(0, 0, size - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
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

    private static void solution(int depth, int left, int right) {
        if (left > right) {
            return;
        }
        int mid = (left + right) / 2;
        adjList[depth].add(nodes[mid]);

        solution(depth + 1, left, mid - 1);
        solution(depth + 1, mid + 1, right);
    }
}