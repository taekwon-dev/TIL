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
            /**
             *  한 개의 블루레이에 모든 강의를 담는 경우가 블루레이 크기의 최댓값이 된다.
             */
            high += lessons[i];
            /**
             *  만약, 강의 수 만큼 블루레이를 포함하고 있을 경우 블루레이 크기의 최솟값은 강의 길이 중 최댓값의 길이와 같다.
             */
            low = Math.max(low, lessons[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int blu_ray = getCount(N, lessons, mid);
            /**
             *  사용할 수 있는 블루레이 개수 M을 기준으로
             *  블루레이 크기 값에 따라 사용한 블루레이 수가
             *  - M보다 큰 경우  : 블루레이 크기를 더 늘려 블루레이 수를 줄여야 한다.
             *  - M보다 작 경우  : 블루레이 크기를 더 줄여 블루레이 수를 늘려야 한다.
             */
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