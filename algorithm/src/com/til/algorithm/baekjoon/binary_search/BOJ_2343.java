package com.til.algorithm.baekjoon.binary_search;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] lecture = new int[N];

        st = new StringTokenizer(br.readLine());
        int low = 0;
        int high = 0;
        for (int i = 0; i < 9; i++) {
            lecture[i] = Integer.parseInt(st.nextToken());
            high += lecture[i];
            low = Math.max(low, lecture[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int bluRay = getBluRay(N, lecture, mid);
            if (bluRay > M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        bw.write(low + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getBluRay(int N, int[] lecture, int mid) {
        int tmp = 0;
        int bluRay = 0;
        for (int i = 0; i < N; i++) {
            if (tmp + lecture[i] > mid) {
                tmp = 0;
                bluRay++;
            }
            tmp += lecture[i];
        }
        if (tmp != 0) {
            bluRay++;
        }
        return bluRay;
    }
}