package com.til.algorithm.softeer;

import java.io.*;
import java.util.StringTokenizer;

public class LV2_GBC {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] source = new int[N][2];
        int[][] target = new int[M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sector = Integer.parseInt(st.nextToken());
            int velocity = Integer.parseInt(st.nextToken());
            source[i][0] = sector;
            source[i][1] = velocity;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sector = Integer.parseInt(st.nextToken());
            int velocity = Integer.parseInt(st.nextToken());
            target[i][0] = sector;
            target[i][1] = velocity;
        }

        int answer = 0;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = idx; j < M; j++) {
                if (source[i][0] < target[j][0]) {
                    target[j][0] -= source[i][0];
                    if (target[j][1] > source[i][1]) {
                        answer = Math.max(answer, target[j][1] - source[i][1]);
                    }
                    break;
                } else if (source[i][0] > target[j][0]) {
                    source[i][0] -= target[j][0];
                    if (target[j][1] > source[i][1]) {
                        answer = Math.max(answer, target[j][1] - source[i][1]);
                    }
                    idx++;
                } else {
                    if (target[j][1] > source[i][1]) {
                        answer = Math.max(answer, target[j][1] - source[i][1]);
                    }
                    idx++;
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