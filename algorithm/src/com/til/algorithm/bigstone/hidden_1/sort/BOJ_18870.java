package com.til.algorithm.bigstone.hidden_1.sort;

import java.io.*;
import java.util.*;

public class BOJ_18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] origin = new int[N];
        int[] sorted = new int[N];
        HashMap<Integer, Integer> rank = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sorted);

        int ranking = 0;
        for (int num : sorted) {
            if (!rank.containsKey(num)) {
                rank.put(num, ranking++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(rank.get(origin[i])).append(" ");
        }

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}