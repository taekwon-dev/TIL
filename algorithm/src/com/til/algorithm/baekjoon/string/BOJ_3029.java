package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_3029 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String currTime = br.readLine();
        String terrorTime = br.readLine();

        if (currTime.equals(terrorTime)) {
            bw.write("24:00:00");
        } else {
            String[] curr = currTime.split(":");
            String[] terror = terrorTime.split(":");

            int[] gap = new int[3];
            for (int i = 0; i < 3; i++) {
                gap[i] = Integer.parseInt(terror[i]) - Integer.parseInt(curr[i]);
            }

            if (gap[2] < 0) {
                gap[2] += 60;
                gap[1] -= 1;
            }

            if (gap[1] < 0) {
                gap[1] += 60;
                gap[0] -= 1;
            }

            if (gap[0] < 0) {
                gap[0] += 24;
            }
            bw.write(String.format("%02d:%02d:%02d", gap[0], gap[1], gap[2]));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}