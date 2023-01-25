package com.til.algorithm.bigstone.week_5;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  https://steady-coding.tistory.com/55
 *
 *  1. 사용하려는 전기 용품의 콘센트가 꽂혀있는 경우, 아무런 행동도 취하지 않는다.
 *  2. 사용하려는 전기 용품의 콘센트가 꽂혀있지 않은 경우
 *      2-1. 멀티탭이 넉넉한 경우, 비어있는 공간에 콘센트를 꽂는다.
 *      2-2. 멀티탭이 넉넉하지 않는 경우, 현재 꽂혀있는 콘센트들이 나중에 사용되는지 확인한다.
 *          2-2-1. 현재 꽂혀있는 콘센트들 중 일부만 나중에 사용된다면, 나중에도 사용되지 않는 콘센트를 제거하고 현재 사용하려는 콘센트를 꽂는다.
 *          2-2-2. 현재 꽂혀있는 콘센트들 중 모두 나중에 사용된다면, 그 중 가장 늦게 사용되는 콘센트를 제거하고 현재 사용하려는 콘센트를 꽂는다.
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
        boolean[] used = new boolean[101];
        int occupied = 0;
        int answer = 0;
        for (int i = 0; i < K; i++) {
            int tmp = order[i];
            if (!used[tmp]) {
                if (occupied < N) {
                    used[tmp] = true;
                    occupied++;
                } else {
                    ArrayList<Integer> offline = new ArrayList<>();
                    for (int j = i; j < K; j++) {
                        if (used[order[j]] && !offline.contains(order[j])) {
                            offline.add(order[j]);
                        }
                    }
                    if (offline.size() != N) {
                        for (int j = 0; j < used.length; j++) {
                            if (used[j] && !offline.contains(j)) {
                                used[j] = false;
                                break;
                            }
                        }
                    } else {
                        int remove = offline.get(offline.size() - 1);
                        used[remove] = false;
                    }
                    answer++;
                    used[tmp] = true;
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
