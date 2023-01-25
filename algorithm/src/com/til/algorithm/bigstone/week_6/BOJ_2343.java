package com.til.algorithm.bigstone.week_6;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  블루레이 크기 범위
 *  - 최솟값
 *  - 최댓값
 */
public class BOJ_2343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] lessons = new int[N];

        st = new StringTokenizer(br.readLine());
        int low = 0;
        int high = 0;
        for (int i = 0; i < N; i++) {
            lessons[i] = Integer.parseInt(st.nextToken());
            high += lessons[i];
            low = Math.max(low, lessons[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int count = getCount(N, lessons, mid);
            if (count > M) {
                // 준비한 블루레이 수가 부족한 경우 = 강의 녹화 길이를 늘려야 한다
                low = mid + 1;
            } else {
                // 준비한 블루레이 수로 가능한 경우 = 강의 녹화 길이를 조금 더 줄여보는 것을 시도한다.
                high = mid - 1;
            }
        }

        bw.write(low + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getCount(int N, int[] lessons, int mid) {
        int tmp = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (tmp + lessons[i] > mid) {
                tmp = 0;
                count++;
            }
            tmp += lessons[i];
        }
        if (tmp != 0) {
            count++;
        }
        return count;
    }
}