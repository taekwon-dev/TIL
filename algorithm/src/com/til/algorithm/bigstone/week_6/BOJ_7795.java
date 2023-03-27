package com.til.algorithm.bigstone.week_6;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7795 {

    private static int[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int[] a = new int[A];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < A; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);

            b = new int[B];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < B; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(b);

            int answer = 0;
            for (int i = 0; i < a.length; i++) {
                answer += binarySearch(a[i]);
            }

            bw.write(answer + "\n");
            bw.flush();
        }

        bw.close();
        br.close();
    }

    private static int binarySearch(int target) {
        int left = 0;
        int right = b.length - 1;
        int idx = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > b[mid]) {
                idx = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return idx + 1;
    }
}