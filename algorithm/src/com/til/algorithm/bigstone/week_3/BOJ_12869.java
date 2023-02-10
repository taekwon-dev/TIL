package com.til.algorithm.bigstone.week_3;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_12869 {

    private static int N;
    private static boolean[][][] visited = new boolean[61][61][61];
    private static int answer = Integer.MAX_VALUE;
    private static ArrayList<Integer> hp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hp.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = N; i < 3; i++) {
            hp.add(0);
        }
        backtracking(hp.get(0), hp.get(1), hp.get(2), 0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int hp1, int hp2, int hp3, int count) {
        hp1 = Math.max(hp1, 0);
        hp2 = Math.max(hp2, 0);
        hp3 = Math.max(hp3, 0);
        int max = Math.max(hp1, Math.max(hp2, hp3));
        int min = Math.min(hp1, Math.min(hp2, hp3));
        int mid = hp1 + hp2 + hp3 - max - min;
        hp1 = max;
        hp2 = mid;
        hp3 = min;

        if (hp1 <= 0 && hp2 <= 0 && hp3 <= 0) {
            answer = Math.min(answer, count);
            return;
        }
        if (visited[hp1][hp2][hp3]) {
            return;
        }
        if (answer < count) {
            return;
        }
        visited[hp1][hp2][hp3] = true;
        backtracking(hp1 - 9, hp2 - 3, hp3 - 1, count + 1);
        backtracking(hp1 - 9, hp2 - 1, hp3 - 3, count + 1);
        backtracking(hp1 - 3, hp2 - 9, hp3 - 1, count + 1);
        backtracking(hp1 - 3, hp2 - 1, hp3 - 9, count + 1);
        backtracking(hp1 - 1, hp2 - 9, hp3 - 3, count + 1);
        backtracking(hp1 - 1, hp2 - 3, hp3 - 9, count + 1);
    }
}