package com.til.algorithm.bigstone.week_5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2109 {

    static class Lecture {
        int pay;
        int day;

        public Lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(pay, day);
        }
        Arrays.sort(lectures, (l1, l2) -> {
            if (l1.pay == l2.pay) {
                return l2.day - l1.day;
            }
            return l2.pay - l1.pay;
        });

        int answer = 0;
        boolean[] fixed = new boolean[10_000 + 1];
        for (int i = 0; i < N; i++) {
            for (int j = lectures[i].day; j >= 1; j--) {
                if (!fixed[j]) {
                    fixed[j] = true;
                    answer += lectures[i].pay;
                    break;
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}