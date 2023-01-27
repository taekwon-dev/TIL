package com.til.algorithm.bigstone.week_5;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  멀티탭 스케줄링
 *
 *  0. 이미 멀티탭에 꽂혀 있는 경우
 *  1. 멀티탭 자리가 있는 경우
 *  2. 멀티탭 자리가 없는 경우
 *      2.1 멀티탭에 꽂혀 있는 콘센트가 모두 나중에 사용되는 경우
 *          2.1.1 멀티탭에 꽂혀 있는 콘센트 중 가장 나중에 사용되는 콘센트를 뺀다.
 *      2.2 멀티탭에 꽂혀 있는 콘센트 중 일부만 나중에 사용되는 경우
 *          2.2.1 멀티탭에 꽂혀 있는 콘센트 중 나중에 사용되지 않는 콘센트를 뺀다.
 */
public class BOJ_1700 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] order = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] put = new boolean[100 + 1];
        int occupied = 0;
        int answer = 0;
        for (int i = 0; i < K; i++) {
            int product = order[i];
            if (!put[product]) {
                if (occupied < N) {
                    put[product] = true;
                    occupied++;
                } else {
                    ArrayList<Integer> offline = new ArrayList<>();
                    for (int j = i; j < K; j++) {
                        if (put[order[j]] && !offline.contains(order[j])) {
                            offline.add(order[j]);
                        }
                    }
                    if (offline.size() != N) {
                        for (int j = 0; j < put.length; j++) {
                            if (put[j] && !offline.contains(j)) {
                                put[j] = false;
                                break;
                            }
                        }
                    } else {
                        int remove = offline.get(offline.size() - 1);
                        put[remove] = false;
                    }
                    answer++;
                    put[product] = true;
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}