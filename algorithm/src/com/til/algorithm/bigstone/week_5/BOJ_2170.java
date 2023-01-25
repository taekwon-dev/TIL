package com.til.algorithm.bigstone.week_5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2170 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] lines = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lines[i][0] = x;
            lines[i][1] = y;
        }
        Arrays.sort(lines, (l1, l2) -> {
            if (l1[0] == l2[0]) {
                // Y 좌표 기준 오름차순
                return l1[1] - l2[1];
            }
            // X 좌표 기준 오름차순
            return l1[0] - l2[0];
        });

        int x = lines[0][0];
        int y = lines[0][1];
        int len = y - x;
        for (int i = 1; i < N; i++) {
            if (x <= lines[i][0] && y >= lines[i][1]) {
                continue;
            }
            if (y > lines[i][0]) {
                len += lines[i][1] - y;
            } else {
                len += lines[i][1] - lines[i][0];
            }
            x = lines[i][0];
            y = lines[i][1];
        }

        bw.write(len + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}