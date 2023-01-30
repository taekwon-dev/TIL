package com.til.algorithm.bigstone.week_6;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  - K가 클수록 적게 인출할 수 있다.
 *  - 돈이 남아도 남은 금액을 반환하고 새로 K를 인출할 수 있다. = M번 이하로 인출한 비용 중 최솟값 구하기
 */
public class BOJ_6236 {

    private static int N;
    private static int[] pay;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        pay = new int[N];

        int low = 1;
        int high = (int) 1e9;
        for (int i = 0; i < N; i++) {
            pay[i] = Integer.parseInt(br.readLine());
            low = Math.max(low, pay[i]);
        }

        int answer = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (withdraw(mid) <= M) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int withdraw(int mid) {
        int count = 1;
        int remain = mid;

        for (int i = 0; i < N; i++) {
            if (remain - pay[i] < 0) {
                remain = mid;
                count++;
            }
            remain -= pay[i];
        }
        return count;
    }
}