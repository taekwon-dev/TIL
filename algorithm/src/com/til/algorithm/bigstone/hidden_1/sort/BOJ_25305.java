package com.til.algorithm.bigstone.hidden_1.sort;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_25305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Integer[] points = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(points, Comparator.reverseOrder());

        bw.write(points[K - 1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}