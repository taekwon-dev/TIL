package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16198 {

    private static ArrayList<Integer> list = new ArrayList<>();
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        backtracking(0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int sum) {
        if (list.size() <= 2) {
            if (answer < sum) {
                answer = sum;
            }
            return;
        }
        for (int i = 1; i < list.size() - 1; i++) {
            int element = list.get(i);
            int val = list.get(i - 1) * list.get(i + 1);
            list.remove(i);
            backtracking(sum + val);
            list.add(i, element);
        }
    }
}