package com.til.algorithm.softeer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LV2_금고털이 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] jewel = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int perValue = Integer.parseInt(st.nextToken());
            jewel[i][0] = weight;
            jewel[i][1] = perValue;
        }

        Arrays.sort(jewel, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            return o2[1] - o1[1];
        });

        int answer = 0;
        outer:
        while (true) {
            for (int i = 0; i < N; i++) {
                if (W <= 0) {
                    break outer;
                }
                if (jewel[i][0] >= W) {
                    answer += W * jewel[i][1];
                    W = 0;
                } else {
                    answer += jewel[i][0] * jewel[i][1];
                    W -= jewel[i][0];
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}