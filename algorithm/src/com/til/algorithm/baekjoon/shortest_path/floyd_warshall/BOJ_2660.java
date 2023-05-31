package com.til.algorithm.baekjoon.shortest_path.floyd_warshall;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2660 {

    private static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (from == -1 && to == -1) {
                break;
            }
            dist[from][to] = 1;
            dist[to][from] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int readerScore = INF;
        int[] scores = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int score = 0;
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] != INF && score < dist[i][j]) {
                    score = dist[i][j];
                }
            }
            scores[i] = score;
            readerScore = Math.min(readerScore, score);
        }
        StringBuilder reader = new StringBuilder();
        StringBuilder candidates = new StringBuilder();
        int candidateNum = 0;
        for (int i = 1; i <= N; i++) {
            if (readerScore == scores[i]) {
                candidateNum++;
                candidates.append(i).append(" ");
            }
        }
        reader.append(readerScore).append(" ").append(candidateNum);

        bw.write(reader.toString() + "\n");
        bw.write(candidates.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}