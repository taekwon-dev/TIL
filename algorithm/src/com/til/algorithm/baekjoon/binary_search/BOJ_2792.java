package com.til.algorithm.baekjoon.binary_search;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2792 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] jewels = new int[M];

        int low = 1;
        int high = 0;
        for (int i = 0; i < M; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, jewels[i]);
        }

        int answer = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            int people = 0;
            for (int jewel : jewels) {
                people += jewel / mid;
                if (jewel % mid != 0) {
                    people++;
                }
            }
            if (people > N) {
                low = mid + 1;
            } else {
                high = mid - 1;
                answer = mid;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}