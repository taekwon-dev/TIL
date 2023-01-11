package com.til.algorithm.bigstone.week_2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2852 {

    static class Timeline {
        int team;
        int time;

        public Timeline(int team, int time) {
            this.team = team;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Timeline[] timelines = new Timeline[N];
        int winTeam = 0;
        int prevRecordTime = 0;
        int[] score = {0, 0};
        int[] answer = {0, 0};

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            String[] scoreTime = st.nextToken().split(":");
            int time = Integer.parseInt(scoreTime[0]) * 60 + Integer.parseInt(scoreTime[1]);
            timelines[i] = new Timeline(team, time);
        }

        winTeam = timelines[0].team;
        prevRecordTime = timelines[0].time;
        score[winTeam - 1]++;

        for (int i = 1; i < N; i++) {
            int currWinTeam = timelines[i].team;
            int currRecordTime = timelines[i].time;

            if (score[0] > score[1]) {
                answer[0] += (currRecordTime - prevRecordTime);
            } else if (score[0] < score[1]) {
                answer[1] += (currRecordTime - prevRecordTime);
            }
            score[currWinTeam - 1]++;
            prevRecordTime = currRecordTime;
        }

        if (score[0] > score[1]) {
            answer[0] += (48 * 60 - prevRecordTime);
        } else if (score[0] < score[1]) {
            answer[1] += (48 * 60 - prevRecordTime);
        }

        for (int i = 0; i < 2; i++) {
            int m = answer[i] / 60;
            int s = answer[i] % 60;
            String mm = null;
            String ss = null;
            if (m < 10) {
                mm = "0" + m;
            } else {
                mm = String.valueOf(m);
            }
            if (s < 10) {
                ss = "0" + s;
            } else {
                ss = String.valueOf(s);
            }
            bw.write(mm + ":" + ss + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}