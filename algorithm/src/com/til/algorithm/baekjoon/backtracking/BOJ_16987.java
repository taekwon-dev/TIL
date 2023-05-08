package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16987 {

    static class Egg {
        int d;
        int w;

        public Egg(int d, int w) {
            this.d = d;
            this.w = w;
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
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(d, w);
        }
        backtracking(0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth) {
        if (depth == N) {
            int brokenEgg = 0;
            for (int i = 0; i < N; i++) {
                if (eggs[i].d <= 0) {
                    brokenEgg++;
                }
            }
            answer = Math.max(answer, brokenEgg);
            return;
        }
        if (eggs[depth].d <= 0) {
            backtracking(depth + 1);
        } else {
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                if (depth == i || eggs[i].d <= 0) {
                    continue;
                }
                flag = true;
                eggs[i].d -= eggs[depth].w;
                eggs[depth].d -= eggs[i].w;
                backtracking(depth + 1);
                eggs[i].d += eggs[depth].w;
                eggs[depth].d += eggs[i].w;
            }
            if (!flag) {
                backtracking(depth + 1);
            }
        }
    }
}