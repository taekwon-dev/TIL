package com.til.algorithm.bigstone.week_6;

import java.io.*;
import java.util.StringTokenizer;

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
            // 한 개의 블루레이에 모든 강의를 담는 경우
            high += lessons[i];
            // 강의 수만큼 블루레이를 사용할 수 있는 경우
            low = Math.max(low, lessons[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int blu_ray = getCount(N, lessons, mid);
            if (blu_ray > M) {
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