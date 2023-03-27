package com.til.algorithm.bigstone.week_6;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1269 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        HashSet<Integer> a = new HashSet<>();
        HashSet<Integer> b = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        for (int element : a) {
            if (!b.contains(element)) {
                answer++;
            }
        }
        for (int element : b) {
            if (!a.contains(element)) {
                answer++;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}