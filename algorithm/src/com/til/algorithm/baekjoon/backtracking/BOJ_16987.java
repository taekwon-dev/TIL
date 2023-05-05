package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16987 {

    static class Egg {
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }

    private static int N;
    private static Egg[] eggs;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int durability = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(durability, weight);
        }
        backtracking(0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int idx) {
        if (idx == N) {
            int egg = 0;
            for (int i = 0; i < N; i++) {
                if (eggs[i].durability <= 0) {
                    egg++;
                }
            }
            answer = Math.max(answer, egg);
            return;
        }
        if (eggs[idx].durability <= 0) {
            backtracking(idx + 1);
        } else {
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                if (idx == i || eggs[i].durability <= 0) {
                    continue;
                }
                flag = true;
                eggs[i].durability -= eggs[idx].weight;
                eggs[idx].durability -= eggs[i].weight;
                backtracking(idx + 1);
                eggs[i].durability += eggs[idx].weight;
                eggs[idx].durability += eggs[i].weight;
            }
            if (!flag) {
                backtracking(idx + 1);
            }
        }
    }
}