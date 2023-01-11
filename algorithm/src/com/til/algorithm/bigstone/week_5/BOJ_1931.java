package com.til.algorithm.bigstone.week_5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1931 {

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end);
        }
        Arrays.sort(meetings, (m1, m2) -> {
            if (m1.end == m2.end) {
                return m1.start - m2.start;
            }
            return m1.end - m2.end;
        });

        int answer = 1;
        int end = meetings[0].end;
        for (int i = 1; i < N; i++) {
            if (meetings[i].start < end) {
                continue;
            }
            end = meetings[i].end;
            answer++;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}