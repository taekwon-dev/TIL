package com.til.algorithm.bigstone.week_5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14469 {

    static class Time {
        int arrivalAt;
        int cost;

        public Time(int arrivalAt, int cost) {
            this.arrivalAt = arrivalAt;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Time[] times = new Time[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int arrivalAt = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            times[i] = new Time(arrivalAt, cost);
        }
        Arrays.sort(times, (t1, t2) -> {
            if (t1.arrivalAt == t2.arrivalAt) {
                return t1.cost - t2.cost;
            }
            return t1.arrivalAt - t2.arrivalAt;
        });

        int answer = 0;
        for (int i = 0; i < times.length; i++) {
            if (times[i].arrivalAt < answer) {
                answer += (times[i].cost);
                continue;
            }
            answer = (times[i].arrivalAt + times[i].cost);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}