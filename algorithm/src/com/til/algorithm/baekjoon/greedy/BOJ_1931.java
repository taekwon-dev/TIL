package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1931 {
    static class Meet implements Comparable<Meet> {
        int s;
        int e;

        public Meet(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Meet o) {
            if (this.e == o.e) {
                return this.s - o.s;
            }
            return this.e - o.e;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Meet> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Meet(s, e));
        }
        Collections.sort(list);
        int result = 1;
        int end = list.get(0).e;
        for (int i = 1; i < n; i++) {
            if (list.get(i).s < end) {
                continue;
            }
            else {
                end = list.get(i).e;
                result += 1;
            }
        }
        System.out.println(result);
    }
}
